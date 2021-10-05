package com.appraisaltool.service;

import java.util.List;
import com.appraisaltool.model.UserTeam;

public interface UserTeamService {
	
	public UserTeam createNewUserTeam(UserTeam userTeam);
	
	public List<Integer> createNewUserTeam(Integer userId, List<Integer> teamIdList);
	
	public List<Integer> getTeamsByUserId(Integer userId); 

    public Integer addTeamToaUser(Integer userId, Integer teamId);
	
}
