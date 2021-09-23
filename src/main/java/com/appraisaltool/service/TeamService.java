package com.appraisaltool.service;

import java.util.List;
import com.appraisaltool.model.Team;

public interface TeamService {
	
    public Team getTeamByName(String name);

    public Team createNewTeam(String teamName);

    public List<Team> getAllTeams();

    public List<String> getTeamNamesByUserId(Long userId);
}
