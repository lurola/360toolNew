package com.appraisaltool.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.appraisaltool.model.UserTeam;

@Repository
public interface UserTeamRepository extends JpaRepository<UserTeam, Integer>{
	
	@Query("SELECT u.teamId FROM UserTeam u WHERE u.userId = ?1")
	List<Integer> findByUserTeamByUserId(Integer userId);

	@Transactional
	@Modifying
	@Query("DELETE FROM UserTeam u WHERE u.userId = ?1")
	void deleteAllByUserId(Integer userId);

}
