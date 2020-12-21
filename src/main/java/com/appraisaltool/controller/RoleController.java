package com.appraisaltool.controller;

import javax.validation.Valid;

import org.dozer.inject.Inject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.appraisaltool.exception.ResourceNotFoundException;
import com.appraisaltool.service.RoleServiceImpl;

@Controller
public class RoleController {

	@Autowired
	private RoleServiceImpl roleServ;
	
	@PreAuthorize("hasAuthority('ADMIN')")
	@GetMapping("/role/loadCreateScreen")
	public ModelAndView loadCreateRoleScreen() {		
		 return new ModelAndView("/new_role_form");
				 
	}
	
	@PreAuthorize("hasAuthority('ADMIN')")
	@PostMapping("/role/create")
	public ModelAndView createOffice(@Valid @ModelAttribute (name="roleName") String roleName) throws ResourceNotFoundException {
		roleServ.createNewRole(roleName);
		
		 return new ModelAndView("/home");
				 
	}
}
