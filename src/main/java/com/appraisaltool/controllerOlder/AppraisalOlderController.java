package com.appraisaltool.controllerOlder;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import com.appraisaltool.dto.AppItemDTO;
import com.appraisaltool.dto.AppraisalDTO;
import com.appraisaltool.dto.AppraisalHeaderDTO;
import com.appraisaltool.dto.EvaluationsDTO;
import com.appraisaltool.dto.ManualAssignmentDTO;
import com.appraisaltool.dto.UserAppraisalDTO;
import com.appraisaltool.encrypting.EncrypterAES;
import com.appraisaltool.model.ApplicationRole;
import com.appraisaltool.model.Appraisal;
import com.appraisaltool.model.AppraisalItem;
import com.appraisaltool.model.AppraisalType;
import com.appraisaltool.model.CriteriaName;
import com.appraisaltool.model.InternalCriteriaSubtype;
import com.appraisaltool.model.InternalCriteriaType;
import com.appraisaltool.model.Office;
import com.appraisaltool.model.User;
import com.appraisaltool.service.OfficeService;
import com.appraisaltool.service.UserService;
import com.appraisaltool.service.impl.AppraisalServiceImp;
import com.appraisaltool.service.impl.OfficeServiceImp;
import com.appraisaltool.service.impl.UserServiceImpl;


@RestController
@RequestMapping("/appraisal")
public class AppraisalOlderController {

    private final AppraisalServiceImp appraisalServ;
    private final UserController userController;

    @Autowired
    private final OfficeService officeServ;
    @Autowired
    private final UserService userService;

    @Autowired
    public AppraisalOlderController(AppraisalServiceImp appraisalServ, UserController userController,  OfficeServiceImp officeServ, UserServiceImpl userServ) {
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
	@GetMapping("/getAppraisal/{id}")
	public Appraisal getAppraisalByAppraisalId(@Valid @ModelAttribute("id") Integer id) {

		return appraisalServ.getAppraisalById(id);
				
	}
	
	
	
	/**
	 * Gets one appraisal by ID
	 * 
	 * @return
	 */
	@PostMapping("/create")
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
	@GetMapping("/manualAssignment")
	public Appraisal manualAssignment(@Valid @ModelAttribute("manualAssignmentDto") ManualAssignmentDTO manualAssignmentDto) {
		
		List<Integer> appraiserAlreadyAssigned = appraisalServ.getAppraiserIdByEvaluatedPersonId(manualAssignmentDto.getUserId());
		Appraisal newAppraisal = null;
		
		//Si no está asignado ya, se asigna, si no, no hacemos nada 
		if(!appraiserAlreadyAssigned.contains(manualAssignmentDto.getAppraiserUserId())) {
            // newAppraisal = appraisalServ.createNewAppraisal(manualAssignmentDto.getUserId(), manualAssignmentDto.getAppraiserUserId(), "", PENDING, null);
		}
		
		
		return newAppraisal; // The redirection will be done in the ftl side.
	}
	
	
	/**
	 * Assigns appraisers for a whole office
	 * 
	 * @return
	 */
	@GetMapping("/assignAppraisers/{id}")
//	public ModelAndView assignAppraisers(@Valid @ModelAttribute("id") Integer officeId) {
	public Boolean assignAppraisers(@Valid @ModelAttribute("id") Integer officeId) {

		//We receive the officeId and generate appraisals for the whole office automatically
		appraisalServ.assignAppraisers(officeId);
		//TODO: revisar lo que se devuelve
		return true;
//		return new ModelAndView("new_appraisal/appraisers_assigned", "model", model);
	}
	
	
	/**
	 * Gets appraisals assigned to a person
	 * 
	 * @return
	 */
	@GetMapping("/getRemainingAppraisalsForAUser/{userId}")
	public ArrayList<UserAppraisalDTO> getRemainingAppraisalsForAUser(@PathVariable("userId") Integer userId) {
		
				
		Integer id = new Integer(userId);
		
		ArrayList<UserAppraisalDTO> peopleToBeEvaluated = new ArrayList<UserAppraisalDTO>();
		
		//Get the appraisals remaining for a specific person
		List<Appraisal> appraisalList = appraisalServ.getRemainingAppraisalsForAUserAndStatus(id,PENDING);
		
		//Go for every person to be evaluated an get his data to show it in the remaining appraisal screen
		for(int i=0; i<appraisalList.size(); i++) {
			Appraisal currentAppraisal = appraisalList.get(i);
            Integer currentId = currentAppraisal.getEvaluatedPerson().getUserId();
		
			UserAppraisalDTO currentUserDTO = userController.getUserDtoData(currentId);
			currentUserDTO.setAppraisalId(currentAppraisal.getAppraisalId());
			peopleToBeEvaluated.add(currentUserDTO);
			
		}
		
		return peopleToBeEvaluated;
		
				
	}
	
	@PostMapping("/newAppraisal")
	public ModelAndView newAppraisal(@Valid @ModelAttribute("idSelected") Integer idSelected) {
		//Get info of the appraisal if exists
		//Go to individual appraisal screen
		Double[] averages;
		
		Integer appraisalId = new Integer(idSelected);
		
		Appraisal appraisal = appraisalServ.getAppraisalById(appraisalId);
		
        CriteriaName[][] criteriaNames = appraisalServ.findAllCriterias(1);
		
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
	@PostMapping("/finish")
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
	@PostMapping("/saveButNotFinish")
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
	 * 
	 * 
	 * @return 
	 */
	@GetMapping("/getFinishedAppraisalsByUser/{userId}")
	public List<AppraisalHeaderDTO> getFinishedAppraisalsByUser(@Valid @ModelAttribute ("userId") Integer userId) {
				
//		Object currentUser = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
        Integer evaluatedPersonId = -1;
		List<Appraisal> appraisalList = appraisalServ.getAppraisalByEvaluatedPersonId(userId, FINISH);
				
		if(appraisalList != null && appraisalList.size() != 0) {
            evaluatedPersonId = appraisalList.get(0).getEvaluatedPerson().getUserId();
		}
				
		List<AppraisalHeaderDTO> appraisalHeaderList = appraisalServ.getAppraisalheaders(appraisalList, evaluatedPersonId, userId);
		
		model = new ModelMap();
		model.addAttribute("appraisalHeaderList", appraisalHeaderList);
//		model.addAttribute("evaluatedPersonId", evaluatedPersonId);
		
//		return new ModelAndView("new_appraisal/appraisals_details", "model", model);
		return appraisalHeaderList;

	}
	
	
	
	/**
	 * Set the appraisals not finished to expired
	 * 
	 * @return 
	 */
    @PreAuthorize("hasAuthority('ADMIN')")
	@GetMapping("/expireAppraisals/{officeId}")
//	public ModelAndView expireAppraisalsNotFinished(@Valid @ModelAttribute ("officeId") Integer officeId) {
	public Integer expireAppraisalsNotFinished(@Valid @ModelAttribute ("officeId") Integer officeId) {
	
		//Setear todos los appraisals que esten abiertos para la oficina indicada como caducados.
		Integer recordsChanged = appraisalServ.setRemainingAppraisalsToExpired(officeId); 
		
		model = new ModelMap();
		model.addAttribute("recordsChanged", recordsChanged);
		return recordsChanged; //TODO: revisar lo que se devuelve

	}
	
	/**
	 * Return the list of users to be displayed, to see their appraisals
	 * 
	 * @param userId
	 * @return
	 */
	@GetMapping("/seeOtherAppraisals/{userId}")
	public List<User> getUserAppraisalsToDisplay(@ModelAttribute ("userId") Integer userId) {
		//For the user received, we display the users available to see their appraisals
		return appraisalServ.getUserAppraisalsToDisplay(userId);
	}
	
	
	/**
	 * Visualize other people's appraisal
	 * 
	 * @return 
	 */
    // @PreAuthorize("hasAuthority('ADMIN')")
//	@GetMapping("/seeOtherAppraisals/{userId}")
//	public ModelAndView seeOtherAppraisals(@Valid @ModelAttribute (name="userId") Integer userId) {
//	
//		//Recuperar los users que podemos visualizar
//		List<User> userListToDisplay = appraisalServ.getUserAppraisalsToDisplay(userId);
//		
//		model = new ModelMap();
//		model.addAttribute("userListToDisplay", userListToDisplay);
//		return new ModelAndView("new_appraisal/other_appraisals", "model", model);
//
//	}
	
	
	/**
	 * Visualize appraisal by Id
	 * 
	 * @return 
	 */
	@GetMapping("/visualizeAppraisal/{idSelected}")
	public Appraisal visualizeAppraisal(@Valid @ModelAttribute ("idSelected") Integer idSelected) {
		
		//TODO: Recuperar 
//		Double[] averages = new Double[10];
//		List<AppraisalItem[][]> appItemList = new ArrayList<AppraisalItem[][]>();
//		//Set the variable allAppraisals to know if we are displaying all apraisals or just one selected
//		
//		//1 is Spanish
//		CriteriaName[][] criteriaNames = appraisalServ.findAllCriterias(1L);
//		//Get all the appItems in order type and subtype
//		AppraisalItem[][] appItems = appraisalServ.getAppItemsByAppraisalId(idSelected);
//		appItemList.add(appItems);
//		
//		AppraisalType[] appType = appraisalServ.findAllAppraisalTypes();
//		
//		averages = appraisalServ.calculateSpecificAppAverages(appItems);
//		
//		model = new ModelMap();
//		model.addAttribute("appType", appType);
//		model.addAttribute("criteriaNames", criteriaNames);
//		model.addAttribute("appItemList", appItemList);
//		model.addAttribute("averages", averages);
//		model.addAttribute("allAppraisals", false);
//		
//		
//		return new ModelAndView("new_appraisal/visualize_appraisal", "model", model);
		
		return getAppraisalByAppraisalId((Integer)idSelected);

	}
	
	//TODO: Devolver list appraisals, notas, criteria
	@GetMapping("/visualizeAllAppraisals/{integerEvalPersonId}")
	public ModelAndView visualizeAllAppraisals(@Valid @ModelAttribute ("integerEvalPersonId") Integer integerEvalPersonId) {
		
		Integer evalPersonId = new Integer(integerEvalPersonId);
		List<AppraisalItem[][]> appItemList = new ArrayList<AppraisalItem[][]>();
		List<Integer> appList = appraisalServ.findAllIdsByEvaluatedPersonIdAndStatus(evalPersonId, FINISH);

		//1 is Spanish
        CriteriaName[][] criteriaNames = appraisalServ.findAllCriterias(1);
		AppraisalType[] appType = appraisalServ.findAllAppraisalTypes();
		
		User evaluatedPerson = userService.getUserByUserId(evalPersonId);
		String evaluatedPersonName = evaluatedPerson.getName() + " " + evaluatedPerson.getSurname();
		
		//Get all the appItems in order type and subtype
		for (Integer currAppId : appList) {
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
	@GetMapping("/loadManualAssignment")
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
	@GetMapping("/loadInternalCriteriaUsersToDisplay/{userId}")
	public List<User> loadInternalCriteriaUsersToDisplay(@Valid @ModelAttribute (name="userId") Integer userId) {
		
		User user = userService.getUserByUserId(userId);
		
		List<User> userListToDisplay = null;
		
		//Recuperar los users que podemos visualizar
		if(user.getAppRole() == ApplicationRole.ADMIN) {
			userListToDisplay = appraisalServ.getUserAppraisalsToDisplay(user.getUserId());
		}
		
//		model = new ModelMap();
//		model.addAttribute("userListToDisplay", userListToDisplay);
//		return new ModelAndView("new_appraisal/internal_criteria_list", "model", model);
		return userListToDisplay;
		
	}
	
	
	/**
	 * Receive the user id and gets the internal criteria associated to this user
	 * @param userId
	 * @return
	 */
    @PreAuthorize("hasAuthority('ADMIN')")
	@GetMapping("/visualizeInternalCriteria/{userId}")
	public ModelAndView visualizeInternalCriteria(@Valid @ModelAttribute (name="userId") Integer userId) {
				
		
		Double[][] internalCriteriaResults = appraisalServ.getInternalCriteriaResults(userId);
		//TODO: REmove 1L from language
        List<InternalCriteriaType> criteriaTitles = appraisalServ.getInternalCriteriaTypes(1);
        List<InternalCriteriaSubtype> criteriaSubtypes = appraisalServ.getGroupCriteriaSubtitles(1);
		
		
		Double[] averages = appraisalServ.getAverages(internalCriteriaResults, userId);
		
		
		model = new ModelMap();
		model.addAttribute("internalCriteriaResults", internalCriteriaResults);
		model.addAttribute("criteriaTitles", criteriaTitles);
		model.addAttribute("criteriaSubtypes", criteriaSubtypes);
		model.addAttribute("averages", averages);
		
		return new ModelAndView("visualize_internal_criteria", "model", model);
		
	}
	
	
	@GetMapping("/getInternalCriteriaTypes/{language}")
	public List<InternalCriteriaType> getInternalCriteriaTypes(@Valid @ModelAttribute (name="language") Integer language) {
			
		return appraisalServ.getInternalCriteriaTypes(language);
	}
	
	
	@GetMapping("/getInternalCriteriaSubTypes/{language}")
	public List<InternalCriteriaSubtype> getInternalCriteriaSubTypes(@Valid @ModelAttribute (name="language") Integer language) {
		return appraisalServ.getGroupCriteriaSubtitles(language);
	}
	

	/**
	 * 
	 * @return 
	 */
	@GetMapping("/getAppraisalTypes/{language}")
	public List<AppraisalType> getAppraisalTypes(@Valid @ModelAttribute (name="language") Integer language) {
		return appraisalServ.getAppraisalTypes();
	}
	
	
	
	@GetMapping("/getCriteriaNames/{language}")
	public List<CriteriaName> getCriteriaNames(@Valid @ModelAttribute (name="language") Integer language) {
		return appraisalServ.getCriteriaNames();
	}
	
	
	@GetMapping("/testEncrypting")
	public String testEncrypting() {
		
		String encriptado = "";
        String desencriptado = "";
		
		 try {
	            final String claveEncriptacion = "secreto!";
	            String datosOriginales = "https://medium.com/el-acordeon-del-programador";            
	             
	            EncrypterAES encriptador = new EncrypterAES();
	             
	            encriptado = encriptador.encriptar(datosOriginales, claveEncriptacion);
	            desencriptado = encriptador.desencriptar(encriptado, claveEncriptacion);
	             
	            System.out.println("Cadena Original: " + datosOriginales);
	            System.out.println("Escriptado     : " + encriptado);
	            System.out.println("Desencriptado  : " + desencriptado);            
	             
	        } catch (UnsupportedEncodingException | NoSuchAlgorithmException | InvalidKeyException | NoSuchPaddingException | IllegalBlockSizeException | BadPaddingException ex) {
	            Logger.getLogger(EncrypterAES.class.getName()).log(Level.SEVERE, null, ex);
	        }
		 
		 return encriptado;
	}
	
	
	
}
