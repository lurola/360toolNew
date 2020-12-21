package com.appraisaltool.service;

import java.util.List;

import com.appraisaltool.model.UserTeam;

public interface UserTeamService {
	
	public UserTeam createNewUserTeam(UserTeam userTeam);
	
	public List<Long> createNewUserTeam(Long userId, List<Long> teamIdList);
	
	public List<Long> getTeamsByUserId(Long userId); 
	
}
