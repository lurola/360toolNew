package com.appraisaltool.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.appraisaltool.model.Team;

@Repository
public interface TeamRepository extends JpaRepository<Team, Integer> {

	public Team getTeamByTeamName(String name);
	
	@Query("SELECT ut.teamId FROM User u INNER JOIN UserTeam ut on (u.userId = ut.userId)  WHERE u.userId = ?1")
    public List<Integer> getTeamByUserId(Integer userId);
	
	
}
