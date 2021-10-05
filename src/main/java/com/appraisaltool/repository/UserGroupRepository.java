package com.appraisaltool.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.appraisaltool.model.UserGroup;

@Repository
public interface UserGroupRepository extends JpaRepository<UserGroup, Integer>{

	@Query("SELECT u.groupId FROM UserGroup u WHERE u.userId = ?1")
	public List<Integer> findByUserGroupByUserId(Integer userId);

	@Transactional
	@Modifying
	@Query("DELETE FROM UserGroup u WHERE u.userId = ?1")
	public void deleteAllByUserId(Integer userId);
	
	@Query("SELECT  eg.userId FROM UserGroup eg WHERE  eg.groupId  IN "
			+ "(SELECT eg.groupId  FROM UserGroup eg INNER JOIN  User e ON eg.userId = e.userId "
			+ "WHERE eg.userId = ?1) AND eg.userId != ?1")
	public List<Integer> findGroupPartners(Integer userId);

	@Query("SELECT u.groupId FROM UserGroup u WHERE u.userId = ?1")
	public List<Integer> getGroupsByUserId(Integer userId);
	
	
}
