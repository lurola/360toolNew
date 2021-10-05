package com.appraisaltool.controllerOlder;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import com.appraisaltool.model.Office;
import com.appraisaltool.model.Team;
import com.appraisaltool.service.OfficeService;
import com.appraisaltool.service.TeamService;

@RestController
@RequestMapping("team")
public class TeamController {
	
    @Autowired
    private TeamService teamServ;
    @Autowired
    private OfficeService officeServ;
    private ModelMap model;

	@PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/loadCreateScreen")
	public ModelAndView loadCreateRoleScreen() {
	
		List<Office> officeList = officeServ.getAllOffices();
		
		model = new ModelMap();
		model.addAttribute("officeList", officeList);
		
		return new ModelAndView("/new_team_form", "model", model);

	}
	
	/**
	 * Save a team
	 * 
	 * @return
	 */
	@PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/create")
	@ResponseBody
    public Integer createTeam(@Valid @ModelAttribute("teamName") String teamName) {
		Team newTeam = teamServ.createNewTeam(teamName);
		return newTeam.getTeamId();
	}
	
	
}
