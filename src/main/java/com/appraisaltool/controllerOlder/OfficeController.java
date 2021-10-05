package com.appraisaltool.controllerOlder;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import com.appraisaltool.exception.ResourceNotFoundException;
import com.appraisaltool.model.Office;
import com.appraisaltool.model.User;
import com.appraisaltool.service.OfficeService;
import com.appraisaltool.service.UserService;

@RestController
@RequestMapping("/office")
public class OfficeController {

    @Autowired
    private OfficeService officeService;
    @Autowired
    private UserService userService;
	
	ModelMap model;

	@GetMapping("/offices")
	public List<Office> getAllOffices() {
		 return officeService.getAllOffices();
	}
	
	
	@GetMapping("/officeById")
	public Office getOfficeById(Integer id) throws ResourceNotFoundException {
        return null;// officeService.getOfficeById(id);
	}
	
    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/loadCreateScreen")
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
    @PostMapping("/create")
	public ModelAndView createOffice(@Valid @ModelAttribute("officeName") String officeName) {
		officeService.createNewOffice(officeName);
		return new ModelAndView("/home", "model", model);
	}
		
}