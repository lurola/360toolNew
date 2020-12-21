package com.appraisaltool.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.appraisaltool.dto.AppItemDTO;
import com.appraisaltool.dto.AppraisalDTO;
import com.appraisaltool.dto.AppraisalHeaderDTO;
import com.appraisaltool.dto.EvaluationsDTO;
import com.appraisaltool.dto.ManualAssignmentDTO;
import com.appraisaltool.dto.UserAppraisalDTO;
import com.appraisaltool.model.ApplicationRole;
import com.appraisaltool.model.Appraisal;
import com.appraisaltool.model.AppraisalItem;
import com.appraisaltool.model.AppraisalType;
import com.appraisaltool.model.CriteriaName;
import com.appraisaltool.model.CurrentUser;
import com.appraisaltool.model.Office;
import com.appraisaltool.model.User;
import com.appraisaltool.service.AppraisalServiceImp;
import com.appraisaltool.service.OfficeServiceImp;
import com.appraisaltool.service.UserServiceImpl;


@Controller
public class AppraisalController {

    private final AppraisalServiceImp appraisalServ;
    private final UserController userController;
    private final OfficeServiceImp officeServ;
    private final UserServiceImpl userService;

    @Autowired
    public AppraisalController(AppraisalServiceImp appraisalServ, UserController userController,  OfficeServiceImp officeServ, UserServiceImpl userServ) {
        this.appraisalServ = appraisalServ;
        this.userController = userController;
        this.officeServ = officeServ;
        this.userService = userServ;
    }
	private Integer FINISH = 1;
	private Integer PENDING = 0;
	
	AppItemDTO appItemDto;

//	private String redirectTo = "";
	ModelMap model;
	
	/**
	 * Gets one appraisal by ID
	 * 
	 * @return
	 */
	@GetMapping("/appraisal/getAppraisal/{id}")
	public ModelAndView getAppraisalByAppraisalId(@Valid @ModelAttribute("id") Long id) {

		Appraisal appraisal = appraisalServ.getAppraisalById(id);		
				
		return new ModelAndView("/home", "model", model);
	}
	
	
	
	/**
	 * Gets one appraisal by ID
	 * 
	 * @return
	 */
	@PostMapping("/appraisal/create")
	public ModelAndView createAppraisal(@Valid @ModelAttribute("appraisal") Appraisal appraisal) {

		appraisalServ.createOrUpdateAppraisal(appraisal);
		
		return new ModelAndView("/home", "model", model);
	}
	
	
	/**
	 * Manual assignment for appraisers
	 * 
	 * @return
	 */
	@PreAuthorize("hasAuthority('ADMIN')")
	@GetMapping("/appraisal/manualAssignment")
	@ResponseBody
	public List<User> manualAssignment(@Valid @ModelAttribute("manualAssignmentDto") ManualAssignmentDTO manualAssignmentDto) {
		
		List<Long> appraiserAlreadyAssigned = appraisalServ.getAppraiserIdByEvaluatedPersonId(manualAssignmentDto.getUserId());
		
		//Si no está asignado ya, se asigna, si no, no hacemos nada 
		if(!appraiserAlreadyAssigned.contains(manualAssignmentDto.getAppraiserUserId())) {
			appraisalServ.createNewAppraisal(manualAssignmentDto.getUserId(), manualAssignmentDto.getAppraiserUserId(), PENDING, null);
		}
		
		
		return null; // The redirection will be done in the ftl side.
	}
	
	
	/**
	 * Assigns appraisers for a whole office
	 * 
	 * @return
	 */
	@GetMapping("/appraisal/assignAppraisers/{id}")
	public ModelAndView assignAppraisers(@Valid @ModelAttribute("id") Long officeId) {

		//We receive the officeId and generate appraisals for the whole office automatically
		appraisalServ.assignAppraisers(officeId);
		return new ModelAndView("new_appraisal/appraisers_assigned", "model", model);
	}
	
	
	/**
	 * Gets appraisals assigned to a person
	 * 
	 * @return
	 */
	@PostMapping("/appraisal/getRemainingAppraisalsForAUser")
	public ModelAndView getRemainingAppraisalsForAUser(@Valid @ModelAttribute("userId") Integer userId) {
		
		
		Long id = new Long(userId);
		
		List<UserAppraisalDTO> peopleToBeEvaluated = new ArrayList<UserAppraisalDTO>();
		
		//Get the appraisals remaining for a specific person
		List<Appraisal> appraisalList = appraisalServ.getRemainingAppraisalsForAUserAndStatus(id,PENDING);
		
		//Go for every person to be evaluated an get his data to show it in the remaining appraisal screen
		for(int i=0; i<appraisalList.size(); i++) {
			Appraisal currentAppraisal = appraisalList.get(i);
			Long currentId= currentAppraisal.getEvaluatedPersonId();
		
			UserAppraisalDTO currentUserDTO = userController.getUserDtoData(currentId);
			currentUserDTO.setAppraisalId(currentAppraisal.getAppraisalId());
			peopleToBeEvaluated.add(currentUserDTO);
			
		}

		model = new ModelMap();
		model.addAttribute("peopleToBeEvaluated", peopleToBeEvaluated);
		
		return new ModelAndView("new_appraisal/remaining_appraisals" , "model", model);
				
	}
	
	@PostMapping("/appraisal/newAppraisal")
	public ModelAndView newAppraisal(@Valid @ModelAttribute("idSelected") Long idSelected) {
		//Get info of the appraisal if exists
		//Go to individual appraisal screen
		Double[] averages;
		
		Long appraisalId = new Long(idSelected);
		
		Appraisal appraisal = appraisalServ.getAppraisalById(appraisalId);
		
		CriteriaName[][] criteriaNames = appraisalServ.findAllCriterias(1L);
		
		//Get all the appItems in order type and subtype
//		AppraisalItem[][] appItems = appraisalServ.getAppItemsByAppraisalId(appraisalId);
		AppraisalType[] appType = appraisalServ.findAllAppraisalTypes();
		
		List<EvaluationsDTO> evaluationValues = EvaluationsDTO.getAllEvaluations();

		model = new ModelMap();
		model.addAttribute("appraisal", appraisal);
		model.addAttribute("appType", appType);
		model.addAttribute("criteriaNames", criteriaNames);
		model.addAttribute("evaluationValues", evaluationValues);
//		model.addAttribute("appItems", appItems);

		return new ModelAndView("complete_appraisal_screen", "model", model);
	}
	
	

	
	
	/**
	 * Confirms the appraisal
	 * 
	 * @return
	 */
	@PostMapping("/appraisal/finish")
	public ModelAndView finish(@Valid @ModelAttribute("appItemDto") AppraisalDTO appraisalDto) {
		
		Appraisal appraisal = appraisalServ.convertFromDtoToAppraisal(appraisalDto);
		
		appraisal.setStatus(FINISH);
		Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("Europe/Paris"));
		Integer evalDate = cal.get(Calendar.YEAR);
		
		appraisal.setEvalDate(evalDate);
		appraisalServ.createOrUpdateAppraisal(appraisal);
		appraisalServ.calculateAndInsertAverages(appraisal.getAppraisalId());
		
		return new ModelAndView("/home");
	}
	
	
	/**
	 * Confirms the appraisal
	 * 
	 * @return
	 */
	@PostMapping("/appraisal/saveButNotFinish")
	public ModelAndView saveButNotFinish(@Valid @ModelAttribute("appItemDto") AppraisalDTO appraisalDto) {
		
		Appraisal appraisal = appraisalServ.convertFromDtoToAppraisal(appraisalDto);
		
		appraisal.setStatus(PENDING);
		Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("Europe/Paris"));
		Integer evalDate = cal.get(Calendar.YEAR);
		
		appraisal.setEvalDate(evalDate);
		appraisalServ.createOrUpdateAppraisal(appraisal);
		
		return new ModelAndView("/home");
	}
	

	/**
	 * Start or continue with an appraisal
	 * 
	 * @return 
	 */
	@PostMapping("/appraisal/getFinishedAppraisalsByUser")
	public ModelAndView getFinishedAppraisalsByUser(@Valid @ModelAttribute ("userId") Integer userId) {
				
		Long  currentUserId = new Long(userId);
		Long evaluatedPersonId = -1L;
		List<Appraisal> appraisalList = appraisalServ.getAppraisalByEvaluatedPersonId(currentUserId, FINISH);
				
		if(appraisalList != null && appraisalList.size() != 0) {
			evaluatedPersonId = appraisalList.get(0).getEvaluatedPersonId();
		}
		
		
		List<AppraisalHeaderDTO> appraisalHeaderList = appraisalServ.getAppraisalheaders(appraisalList, evaluatedPersonId);
		

		model = new ModelMap();
		model.addAttribute("appraisalHeaderList", appraisalHeaderList);
		model.addAttribute("evaluatedPersonId", evaluatedPersonId);
		
		
		return new ModelAndView("new_appraisal/appraisals_details", "model", model);

	}
	
	
	
	/**
	 * Set the appraisals not finished to expired
	 * 
	 * @return 
	 */
	@PreAuthorize("hasAuthority('ADMIN')")
	@GetMapping("/appraisal/expireAppraisals/{officeId}")
	public ModelAndView expireAppraisalsNotFinished(@Valid @ModelAttribute ("officeId") Long officeId) {
	
		//Setear todos los appraisals que esten abiertos para la oficina indicada como caducados.
		Integer recordsChanged = appraisalServ.setRemainingAppraisalsToExpired(officeId); 
		
		System.out.println("recordsChanged: " + recordsChanged);
		
		model = new ModelMap();
		model.addAttribute("recordsChanged", recordsChanged);
		return new ModelAndView("/", "model", model);

	}
	
	
	/**
	 * Visualize other people's appraisal
	 * 
	 * @return 
	 */
	@PreAuthorize("hasAuthority('ADMIN')")
	@GetMapping("/appraisal/seeOtherAppraisals/{userId}")
	public ModelAndView seeOtherAppraisals(@Valid @ModelAttribute (name="userId") Long userId) {
	
		//Recuperar los users que podemos visualizar
		List<User> userListToDisplay = appraisalServ.getUserAppraisalsToDisplay(userId);
		
		model = new ModelMap();
		model.addAttribute("userListToDisplay", userListToDisplay);
		return new ModelAndView("new_appraisal/other_appraisals", "model", model);

	}
	
	
	/**
	 * Visualize appraisal by Id
	 * 
	 * @return 
	 */
	@PostMapping("/appraisal/visualizeAppraisal")
	public ModelAndView visualizeAppraisal(@Valid @ModelAttribute ("idSelected") Long idSelected) {
		
		Double[] averages = new Double[10];
		List<AppraisalItem[][]> appItemList = new ArrayList<AppraisalItem[][]>();
		//Set the variable allAppraisals to know if we are displaying all apraisals or just one selected
		
		//1 is Spanish
		CriteriaName[][] criteriaNames = appraisalServ.findAllCriterias(1L);
		//Get all the appItems in order type and subtype
		AppraisalItem[][] appItems = appraisalServ.getAppItemsByAppraisalId(idSelected);
		appItemList.add(appItems);
		
		AppraisalType[] appType = appraisalServ.findAllAppraisalTypes();
		
		averages = appraisalServ.calculateSpecificAppAverages(appItems);
		
		model = new ModelMap();
		model.addAttribute("appType", appType);
		model.addAttribute("criteriaNames", criteriaNames);
		model.addAttribute("appItemList", appItemList);
		model.addAttribute("averages", averages);
		model.addAttribute("allAppraisals", false);
		
		
		return new ModelAndView("new_appraisal/visualize_appraisal", "model", model);

	}
	
	
	@GetMapping("/appraisal/visualizeAllAppraisals/{integerEvalPersonId}")
	public ModelAndView visualizeAllAppraisals(@Valid @ModelAttribute ("integerEvalPersonId") Integer integerEvalPersonId) {
		
		Long evalPersonId = new Long(integerEvalPersonId);
		List<AppraisalItem[][]> appItemList = new ArrayList<AppraisalItem[][]>();
		List<Long> appList = appraisalServ.findAllIdsByEvaluatedPersonIdAndStatus(evalPersonId, FINISH);

		//1 is Spanish
		CriteriaName[][] criteriaNames = appraisalServ.findAllCriterias(1L);
		AppraisalType[] appType = appraisalServ.findAllAppraisalTypes();
		
		User evaluatedPerson = userService.getUserByUserId(evalPersonId);
		String evaluatedPersonName = evaluatedPerson.getName() + " " + evaluatedPerson.getSurname();
		
		//Get all the appItems in order type and subtype
		for (Long currAppId : appList) {
			appItemList.add(appraisalServ.getAppItemsByAppraisalId(currAppId));		
		}
			
		model = new ModelMap();
		model.addAttribute("appType", appType);
		model.addAttribute("criteriaNames", criteriaNames);
		model.addAttribute("appItemList", appItemList);
		model.addAttribute("evaluatedPersonName", evaluatedPersonName);
		model.addAttribute("allAppraisals", true);
		
		return new ModelAndView("new_appraisal/visualize_appraisal", "model", model);

	}
	
	
	/**
	 * Load the screen to assign manually appraisal
	 * 
	 * @return 
	 */
	@PreAuthorize("hasAuthority('ADMIN')")
	@GetMapping("/appraisal/loadManualAssignment")
	public ModelAndView loadManualAssignment() {
		
		List<Office> officeList = officeServ.getAllOffices();
		
		model = new ModelMap();
		model.addAttribute("officeList", officeList);
				
		return new ModelAndView("manual_assignment", "model", model);

	}
	
	
	/**
	 * Show the users list to select the internal criteria to be display
	 * @param userId
	 * @return
	 */
	@PreAuthorize("hasAuthority('ADMIN')")
	@GetMapping("/appraisal/loadInternalCriteriaScreen/{userId}")
	public ModelAndView loadInternalCriteriaScreen(@Valid @ModelAttribute (name="userId") Long userId) {
		
		User user = userService.getUserByUserId(userId);
		
		List<User> userListToDisplay = null;
		
		//Recuperar los users que podemos visualizar
		if(user.getAppRole() == ApplicationRole.ADMIN) {
			userListToDisplay = appraisalServ.getUserAppraisalsToDisplay(user.getUserId());
		}
		
		model = new ModelMap();
		model.addAttribute("userListToDisplay", userListToDisplay);
		return new ModelAndView("new_appraisal/internal_criteria_list", "model", model);
		
	}
	
	
	/**
	 * Receive the user id and gets the internal criteria associated to this user
	 * @param userId
	 * @return
	 */
	@PreAuthorize("hasAuthority('ADMIN')")
	@GetMapping("/appraisal/visualizeInternalCriteria/{userId}")
	public ModelAndView visualizeInternalCriteria(@Valid @ModelAttribute (name="userId") Long userId) {
				
		
		Double[][] internalCriteriaResults = appraisalServ.getInternalCriteriaResults(userId);
		String[] criteriaTitles = appraisalServ.getGroupCriteriaNames();
		String[][] criteriaSubtypes = appraisalServ.getGroupCriteriaSubtitles();
		
		
		Double[] averages = appraisalServ.getAverages(internalCriteriaResults, userId);
		
		
		model = new ModelMap();
		model.addAttribute("internalCriteriaResults", internalCriteriaResults);
		model.addAttribute("criteriaTitles", criteriaTitles);
		model.addAttribute("criteriaSubtypes", criteriaSubtypes);
		model.addAttribute("averages", averages);
		
		return new ModelAndView("visualize_internal_criteria", "model", model);
		

	}
	
}
