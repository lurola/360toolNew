package com.appraisaltool.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.appraisaltool.dto.ChangePasswordDTO;
import com.appraisaltool.dto.MentorAssignmentDTO;
import com.appraisaltool.dto.NewUserDTO;
import com.appraisaltool.dto.UserAppraisalDTO;
import com.appraisaltool.model.Office;
import com.appraisaltool.model.User;
import com.appraisaltool.model.UserGroupId;
import com.appraisaltool.model.UserTeamId;
import com.appraisaltool.service.impl.GroupServiceImpl;
import com.appraisaltool.service.impl.OfficeServiceImp;
import com.appraisaltool.service.impl.RoleServiceImpl;
import com.appraisaltool.service.impl.TeamServiceImpl;
import com.appraisaltool.service.impl.UserGroupServiceImpl;
import com.appraisaltool.service.impl.UserServiceImpl;
import com.appraisaltool.service.impl.UserTeamServiceImpl;

@RestController
public class UserController {	
	@Autowired private UserServiceImpl userService;
	@Autowired private OfficeServiceImp officeService;
	@Autowired private TeamServiceImpl teamService;
	@Autowired private RoleServiceImpl roleService;
	@Autowired private UserTeamServiceImpl userTeamServ;
	@Autowired private UserGroupServiceImpl userGroupServ;
	@Autowired private GroupServiceImpl groupServ;
	

	ModelMap model;
	
	/**
	 * 
	 * @return
	 */
	@PreAuthorize("hasAuthority('ADMIN')")
	@GetMapping("/user/create")
	public ModelAndView getUserCreationForm() {
		
		fillComboValluesToModelMap();
		model.addAttribute("userForm", new NewUserDTO());
		model.addAttribute("signUp", false);
		return new ModelAndView("/new_user_form", "model", model);
	}
	
	/**
	 * 
	 * @param form
	 * @return
	 */
	@PostMapping(value = "/user/create")
    public ModelAndView createUser(@Valid @ModelAttribute("userForm") NewUserDTO form) {
		
        userService.createNewUser(form);
    	return new ModelAndView("/home");
    }
	
	
	
	/**
	 * 
	 * @return
	 */
	@GetMapping("/user/signup")
	public ModelAndView loadSignUpScreen() {
		
		fillComboValluesToModelMap();
		model.addAttribute("signUp", true);
		model.addAttribute("userForm", new NewUserDTO());
		
		return new ModelAndView("/new_user_form", "model", model);
	}
	
	
	/**
	 * 
	 * @param form
	 * @return
	 */
	@PostMapping(value = "/user/signup")
    public ModelAndView signup(@Valid @ModelAttribute("userForm") NewUserDTO form) {
		
        userService.createNewUser(form);
    	return new ModelAndView("/login");
    }
	
	

	
	/**
	 * Gets all the information for a user and displays it in the form.
	 * 
	 * @param id
	 * @param bindingResult
	 * @return
	 */
	@GetMapping("/user/updateprofile/{id}")
    public ModelAndView getUserUpdateForm(@Valid @ModelAttribute("id") Long id , BindingResult bindingResult) {
		
		NewUserDTO userForm = userService.getUserCreateFormByUserId(id);
		
		fillComboValluesToModelMap();
		
        this.model.addAttribute("userForm", userForm);
    	return new ModelAndView("update_user_form", "model" , model);    	
    }
	
	/**
	 * Updates user information
	 * 
	 * @param updateUserform
	 * @return
	 */
	@PostMapping("/user/updateprofile/{id}")
	public ModelAndView updateUser(@Valid @ModelAttribute("userForm") NewUserDTO updateUserform) {
	
		userService.updateUser(updateUserform);
		
    	return new ModelAndView("/home"); 
	}

	
	@GetMapping("/user/remindpassword")
	public ModelAndView remindForgotPassword() {

		return new ModelAndView("/remind_password_form"); 
	}
	
	/**
	 * Sets the model with all the dropDowns
	 */
	private void fillComboValluesToModelMap() {
		this.model = new ModelMap();
		this.model.addAttribute("officeList", officeService.getAllOffices());
		this.model.addAttribute("officeList2", officeService.getAllOffices());
		this.model.addAttribute("roleList", roleService.getAllRoles());
		this.model.addAttribute("teamList", teamService.getAllTeams());	
		this.model.addAttribute("groupList", groupServ.getAllGroups());
		
	}
	
	/**
	 * Gets the basic data for a user
	 * 
	 * @param userId
	 * @return
	 */
	public UserAppraisalDTO getUserDtoData(Long userId) {
		UserAppraisalDTO userDto = new UserAppraisalDTO();
		
		User user = userService.getUserByUserId(userId);
		
		userDto.setOffice(officeService.getOfficeById(user.getOfficeId()).getOfficeName());
		userDto.setRole(roleService.getRoleById(user.getRoleId()).getRoleName());
		userDto.setTeam(teamService.getTeamNamesByUserId(userId));
		userDto.setUserName(user.getName() + " " + user.getSurname());
		

		return userDto;
	}
	
	
	
	/**
	 * Get users by officeId
	 * 
	 * @return
	 */
	@GetMapping("/user/getUserByOfficeId")
	@ResponseBody
	public List<User> getUsersByOfficeId(@Valid @ModelAttribute("officeId") Long officeId) {
		return userService.getUserSByOfficeId(officeId);
	}
	
	
	/**
	 * Get screen to change password
	 * 
	 * @return
	 */
	@GetMapping("/user/loadChangePasswordScreen/{userId}")
	public ModelAndView loadChangePasswordScreen(@Valid @ModelAttribute("userId") Long userId) {
		
		
		model = new ModelMap();
		model.addAttribute("userId", userId);
		return new ModelAndView("/change_password_form", "model", model);
	}
	
	
	/**
	 * Get screen to change password
	 * 
	 * @return
	 */
	@PreAuthorize("hasAuthority('ADMIN')")
	@GetMapping("/user/loadUserSearchScreen")
	public ModelAndView loadUserSearchScreen() {
		
		model = new ModelMap();		
		model.addAttribute("officeList", officeService.getAllOffices());
		
		return new ModelAndView("/user_search", "model", model);
	}
	
	
	/**
	 * Changes the password
	 * 
	 * @return
	 */
	@PostMapping("/user/changePassword")
	public ModelAndView changePassword(@Valid @ModelAttribute (name= "newPassword") ChangePasswordDTO chPasswordDto) {
		
		if(!chPasswordDto.getNewPassword().equals(chPasswordDto.getRepeatedPassword())) {
			return loadChangePasswordScreen(chPasswordDto.getUserId());
		}else {
			
			userService.changePassword(chPasswordDto);
			return new ModelAndView("/home");
			
		}
		
	}
	
	/**
	 * 
	 * @param userGroup
	 * @return
	 */
	@GetMapping("/user/assignUserToTeam")
	@ResponseBody
	public UserTeamId assignUserToTeam(@Valid @ModelAttribute(name = "userGroup") UserTeamId userGroup) {
		
		//Llamar a un servicio que setee el team al usuario
		userTeamServ.addTeamToaUser(userGroup.getUserId(), userGroup.getTeamId());
		return userGroup;
		
	}
	
	
	
	
	@GetMapping("/user/assignUserToGroup")
	@ResponseBody
	public UserGroupId assignUserToGroup(@Valid @ModelAttribute(name = "userGroup") UserGroupId userGroup) {
		
		//Llamar a un servicio que setee el team al usuario
		userGroupServ.addGroupToaUser(userGroup.getUserId(), userGroup.getGroupId());
		return userGroup;
		
	}
	
	
	/**
	 * Get screen to change password
	 * 
	 * @return
	 */
	@PostMapping("/user/searchByNameorSurname")
	public ModelAndView userSearch(@Valid @ModelAttribute(name = "user") User user) {

		if(user.getOfficeId() == 0) {
			user.setOfficeId(null);
		}
		
		List<User> userList = userService.getByQuery(user.getName(), user.getSurname(), user.getOfficeId());
		
		model = new ModelMap();
		model.addAttribute("userList", userList);
		return new ModelAndView("user_search", "model", model);
		
	}
	
	@GetMapping("/user/loadAssignMentorScreen")
	public ModelAndView loadAssignMentorScreen(@Valid @ModelAttribute(name = "user") MentorAssignmentDTO mentorAssignmentDto) {
		
		List<Office> officeList = officeService.getAllOffices();
		
		model = new ModelMap();
		model.addAttribute("officeList", officeList);
		
		return new ModelAndView("/mentor_assignment", "model", model);
		
	}
	
	
	@ResponseBody
	@GetMapping("/user/assignMentor")
	public String assignMentor(@Valid @ModelAttribute(name = "user") MentorAssignmentDTO mentorAssignmentDto) {
		
		userService.assignMentor(mentorAssignmentDto);	
		return "";
		
	}
	
	
	@GetMapping("/user/initializeUser/{userId}")
	public ModelAndView loadInitializeUserScreen(@Valid @ModelAttribute(name = "userId") Long userId) {
		
		model = new ModelMap();
		model.addAttribute("userId", userId);
		return new ModelAndView("initialize_user", "model", model);
		
		
	}
	
	
	@PostMapping("/user/initializeUser")
	public ModelAndView initializeUser(@Valid @ModelAttribute(name = "chPasswordDto") ChangePasswordDTO usechPasswordDtorId) {
		
		Boolean success = userService.initilizePassword(usechPasswordDtorId); 

		model = new ModelMap();
		model.addAttribute("userId", usechPasswordDtorId.getUserId());
		
		if(success) {
			return new ModelAndView("/login", "model", model);
		} else {
			return new ModelAndView("/initialize_user", "model", model);
		}
		
		
		
	}

}
