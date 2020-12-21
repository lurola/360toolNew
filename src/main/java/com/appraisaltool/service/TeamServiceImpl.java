package com.appraisaltool.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.appraisaltool.model.Team;
import com.appraisaltool.repository.TeamRepository;

@Service
public class TeamServiceImpl implements TeamService{

	@Autowired private TeamRepository teamRepository;
	
	private static final Logger logger = LogManager.getLogger(OfficeServiceImp.class);
	
	/**
	 * Get one team by its id
	 * @param id
	 */
	public Team getTeamById(@PathVariable(value = "id") Long teamId)  {
		logger.debug("[OfficeServiceImp] calling getOfficeById");
		Team team = teamRepository.getOne(teamId);
		return team;
	}

	/**
	 * Get one office by its ID
	 * @param name
	 */
	@Override
	public Team getTeamByName(@PathVariable(value = "name") String name) {

		Team office = teamRepository.getTeamByTeamName(name);
		return office;
	}

	/**
	 * Get all the offices 
	 */
	public List<Team> getAllTeams() {
		logger.debug("[OfficeServiceImp] calling getAllOffices");
		return teamRepository.findAll();
	}

	/**
	 * Creates a new Team
	 *@param team
	 */
	public Team createNewTeam(Team team) {
		logger.debug("[OfficeServiceImp] calling createNewOffice");
		return teamRepository.save(team);
	}
	
	public Team createNewTeam(String teamName) {
		logger.debug("[OfficeServiceImp] calling createNewOffice (String)");
		Team t = new Team();
		t.setTeamName(teamName);
		return teamRepository.save(t);
	}
	
	
	/**
	 * Deletes a Team by its ID
	 * @param teamId
	 */
	public void deleteTeam(Long teamId) {
		logger.debug("[OfficeServiceImp] calling createNewOffice");
		teamRepository.deleteById(teamId);
	}

	/**
	 * Get the list of ids for a specific person
	 * 
	 * @param userId
	 * @return
	 */
	public List<Long> getTeamByUserId(Long userId) {

		List<Long> teamIdList = teamRepository.getTeamByUserId(userId);		
		return teamIdList;
	}
	
	public List<String> getTeamNamesByUserId (Long userId) {
		List<Long> idList = getTeamByUserId(userId);
		List<String> teamNames = new ArrayList<String>();
		
		for(int i=0; i<idList.size(); i++) {
			Team team = teamRepository.getOne(idList.get(i));
			teamNames.add(team.getTeamName());
		}
		
		return teamNames;
		
	}
	
	

	
}
