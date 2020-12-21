package com.appraisaltool.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.appraisaltool.model.Group;
import com.appraisaltool.model.Office;
import com.appraisaltool.service.GroupServiceImpl;
import com.appraisaltool.service.OfficeServiceImp;

@Controller
public class GroupController {
	
	@Autowired private GroupServiceImpl groupServ;
	@Autowired private OfficeServiceImp officeServ;
	public ModelMap model;
	
	@PreAuthorize("hasAuthority('ADMIN')")
	@GetMapping("/group/loadCreateScreen")
	public ModelAndView loadNewGroupScreen()  {
		
		List<Office> officeList = officeServ.getAllOffices();
		
		model = new ModelMap();
		model.addAttribute("officeList", officeList);
		
		return new ModelAndView("new_group_form" , "model" , model);
	}
	
	
//	@PostMapping("/group/create")
//	public ModelAndView createGroup(@Valid @ModelAttribute (name="groupName") String groupName) {
//		groupServ.createNewGroup(groupName);
//		
//		 return new ModelAndView("/home");
//				 
//	}
	
	
	/**
	 * Save a group
	 * 
	 * @return
	 */
	@GetMapping("/group/create") 
	@ResponseBody
	public Long createTeam(@Valid @ModelAttribute("groupName") String groupName) {
		Group group = groupServ.createNewGroup(groupName);
		return group.getGroupId();
	}

}
