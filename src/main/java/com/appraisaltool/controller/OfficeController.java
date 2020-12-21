package com.appraisaltool.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.appraisaltool.exception.ResourceNotFoundException;
import com.appraisaltool.model.Office;
import com.appraisaltool.model.User;
import com.appraisaltool.service.OfficeServiceImp;
import com.appraisaltool.service.UserServiceImpl;

@Controller
public class OfficeController {

	@Autowired private OfficeServiceImp officeService;
	@Autowired private UserServiceImpl userService;
	
	ModelMap model;

	@GetMapping("/offices")
	public ModelAndView getAllOffices() {
		 List<Office> officeList = officeService.getAllOffices();
		 return null;
	}
	
	
	@GetMapping("/officeById")
	public ModelAndView getOfficeById(long id) throws ResourceNotFoundException {
		 Office office =  officeService.getOfficeById(id);
		 return null;
	}
	
	@PreAuthorize("hasAuthority('ADMIN')")
	@GetMapping("/office/loadCreateScreen")
	public ModelAndView loadNewOfficeScreen()  {
		//Get users with no office
		List<User> userList = userService.getUserSByOfficeId(null);
		
		model = new ModelMap();
		model.addAttribute("userList", userList);
				
		return new ModelAndView("new_office_form", "model", model);
		
	}
	
	/**
	 * Save an office
	 * 
	 * @return
	 */
	@PreAuthorize("hasAuthority('ADMIN')")
	@PostMapping("/office/create")
	public ModelAndView createOffice(@Valid @ModelAttribute("officeName") String officeName) {
		officeService.createNewOffice(officeName);
		return new ModelAndView("/home", "model", model);
	}
		
}