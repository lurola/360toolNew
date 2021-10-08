package com.appraisaltool.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.appraisaltool.dto.NewUserDTO;
import com.appraisaltool.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	@Query("SELECT u FROM User u WHERE u.userId IN ?1")
	public List<User> getUsersInList(List<Integer> userId);
	
    @Query("SELECT u FROM User u WHERE u.isLineManager = TRUE ")
    public List<User> getUserLineManager();

    @Query("SELECT u FROM User u WHERE u.isTeamLead = TRUE ")
    public List<User> getUserTeamLead();

    @Query("SELECT u FROM User u WHERE u.isMentor = TRUE ")
    public List<User> getUserMentor();

	public Optional<User> findOneByEmail(String email);
	
	public User findOneByUserId(Integer id);

    @Query("SELECT u FROM User u WHERE u.office.officeId IN ?1")
	public List<User> findAllUsersByOfficeId(Integer officeId);

	public NewUserDTO save(NewUserDTO user);
	
    @Query("SELECT u FROM User u WHERE u.mentor.userId IN ?1")
	public List<User> findAllUsersByMentorId(Integer mentorId);

    @Query("SELECT distinct u FROM User u INNER JOIN UserTeam ut on (u.userId = ut.userId)  WHERE ut.teamId IN ?1 and u.role.roleId IN ?2")
    public List<User> getUsersByTeamAndRole(List<Integer> teamId, List<Integer> role);

	
	@Query("SELECT  eg.userId FROM UserTeam eg WHERE  eg.teamId  IN "
			+ "(SELECT eg.teamId  FROM UserTeam eg INNER JOIN  User e ON eg.userId = e.userId "
			+ "WHERE eg.userId = ?1) AND eg.userId != ?1")
	public List<Integer> findTeamMates(Integer userId);

	@Query("SELECT eg.userId FROM UserTeam eg WHERE eg.teamId IN (SELECT eg.teamId FROM UserTeam eg INNER JOIN User e ON eg.userId = e.userId WHERE eg.userId = ?1) AND eg.userId != ?1 AND eg.userId not in (SELECT eg.userId FROM UserGroup eg WHERE eg.groupId IN (SELECT eg.groupId FROM UserGroup eg INNER JOIN User e ON eg.userId = e.userId WHERE eg.userId = ?1) and userId != ?1)")
	public List<Integer> findTeamMatesNoGroup(Integer userId);
	
    @Query("SELECT m FROM User m where (?1 is null or upper(m.name) like concat('%', upper(?1), '%')) AND (?2 is null or upper(m.surname) like concat('%', upper(?2), '%')) AND (?3 is null or m.office.officeId = ?3)")
	public List<User> getByQuery(String name, String surname, Integer officeId);

    @Query("SELECT u FROM User u INNER JOIN UserTeam ut ON u.userId = ut.userId WHERE u.userId !=?1    AND ut.teamId IN (SELECT ut2.teamId FROM UserTeam ut2 WHERE ut2.userId = ?1) AND NOT EXISTS (SELECT 1 FROM Appraisal a WHERE a.evaluatedPerson.userId = u.userId AND a.appraiser.userId = ?1)")
    public List<User> findTeamMatesNoAppariserBy(Integer userId);

    @Query("SELECT u FROM User u INNER JOIN UserGroup ug ON u.userId = ug.userId WHERE u.userId !=?1    AND ug.groupId IN (SELECT ug2.groupId FROM UserGroup ug2 WHERE ug2.userId = ?1) AND NOT EXISTS (SELECT 1 FROM Appraisal a WHERE a.evaluatedPerson.userId = u.userId AND a.appraiser.userId = ?1)")
    public List<User> findGroupMatesNoAppariserBy(Integer userId);

}
