package com.appraisaltool.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.appraisaltool.dto.NewUserDTO;
import com.appraisaltool.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	@Query("SELECT u FROM User u WHERE u.userId IN ?1")
	public List<User> getUsersInList(List<Long> userId);
	
	public Optional<User> findOneByEmail(String email);
	
	public User findOneByUserId(Long id);

	public List<User> findAllUsersByOfficeId(Long officeId);

	public NewUserDTO save(NewUserDTO user);
	
	public List<User> findAllUsersByMentorId(Long mentorId);

	@Query("SELECT distinct u FROM User u INNER JOIN UserTeam ut on (u.userId = ut.userId)  WHERE ut.teamId IN ?1 and u.roleId IN ?2")
	public List<User> getUsersByTeamAndRole(List<Long> teamId, List<Integer> role);

	
	@Query("SELECT  eg.userId FROM UserTeam eg WHERE  eg.teamId  IN "
			+ "(SELECT eg.teamId  FROM UserTeam eg INNER JOIN  User e ON eg.userId = e.userId "
			+ "WHERE eg.userId = ?1) AND eg.userId != ?1")
	public List<Long> findTeamMates(Long userId);

	@Query("SELECT eg.userId FROM UserTeam eg WHERE eg.teamId IN (SELECT eg.teamId FROM UserTeam eg INNER JOIN User e ON eg.userId = e.userId WHERE eg.userId = ?1) AND eg.userId != ?1 AND eg.userId not in (SELECT eg.userId FROM UserGroup eg WHERE eg.groupId IN (SELECT eg.groupId FROM UserGroup eg INNER JOIN User e ON eg.userId = e.userId WHERE eg.userId = ?1) and userId != ?1)")
	public List<Long> findTeamMatesNoGroup(Long userId);
	
	@Query("SELECT m FROM User m where (?1 is null or upper(m.name) like concat('%', upper(?1), '%')) AND (?2 is null or upper(m.surname) like concat('%', upper(?2), '%')) AND (?3 is null or m.officeId = ?3)")
	public List<User> getByQuery(String name, String surname, Long officeId);

}
