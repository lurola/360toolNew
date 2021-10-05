package com.appraisaltool.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appraisaltool.model.UserTeam;
import com.appraisaltool.model.UserTeamId;
import com.appraisaltool.repository.UserTeamRepository;
import com.appraisaltool.service.UserTeamService;

@Service
public class UserTeamServiceImpl implements UserTeamService{

	@Autowired UserTeamRepository userTeamRepository;
	
	@Override
	public UserTeam createNewUserTeam(UserTeam userTeam) {
		return userTeamRepository.save(userTeam);
	}
	
	
	public Integer addTeamToaUser(Integer userId, Integer teamId) {
		
		UserTeamId userTeamId = new UserTeamId(userId, teamId);
		
		UserTeam userTeam = new UserTeam();
		userTeam.setUserTeamId(userTeamId);
		userTeam.setTeamId(teamId);
		userTeam.setUserId(userId);
		userTeamRepository.save(userTeam);
		
		
		return teamId;
	}
	
	
	@Override
	public List<Integer> createNewUserTeam(Integer userId, List<Integer> teamIdList) {
		
		UserTeamId userTeamId;
		
		userTeamRepository.deleteAllByUserId(userId);
		
		for(int i=0; i<teamIdList.size(); i++) {
			Integer teamId = teamIdList.get(i);
			
			userTeamId = new UserTeamId(userId, teamId);
			UserTeam userTeam = new UserTeam();
			userTeam.setUserTeamId(userTeamId);
			userTeam.setTeamId(teamId);
			userTeam.setUserId(userId);
			userTeamRepository.save(userTeam);
		}		
		
		return teamIdList;
	}


	@Override
	public List<Integer> getTeamsByUserId(Integer userId) {
		List<Integer> teams = userTeamRepository.findByUserTeamByUserId(userId);
		
		return teams;
	}
	
}


