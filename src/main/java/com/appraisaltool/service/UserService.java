package com.appraisaltool.service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import com.appraisaltool.dto.ChangePasswordDTO;
import com.appraisaltool.dto.MentorAssignmentDTO;
import com.appraisaltool.dto.NewUserDTO;
import com.appraisaltool.dto.domain.EmployeeFilterListType;
import com.appraisaltool.model.User;

public interface UserService {

	public User getUserByUserId(Integer id);

    public Optional<User> getUserByEmail(String email);

    public Collection<User> getAllUsers();

    public List<User> getUserSByOfficeId(Integer officeId);

	public NewUserDTO createNewUser(NewUserDTO user);
	
	public NewUserDTO updateUser(NewUserDTO userCreateForm);

    public NewUserDTO getUserCreateFormByUserId(Integer userId);

    public User createNewEmployee(User user);

    public User updateUser(User user);

    public void changePassword(ChangePasswordDTO chPasswordDto);

    public List<User> getByQuery(String name, String surname, Integer officeId);

    public Boolean assignMentor(MentorAssignmentDTO mentorAssigDto);

    public Boolean initilizePassword(ChangePasswordDTO usechPasswordDtorId);

    public List<Integer> findTeamMates(Integer userId);

    public List<User> getUsersInList(List<Integer> listIdUser);

    public List<User> getMentorized(Integer userId);

    public List<Integer> findTeamMatesNoGroup(Integer userId);

    public List<User> getUsersByTeamAndRole(List<Integer> teamId, Integer role);

    public List<Integer> findGroupMates(Integer userId);

    public List<User> getEmployeeByFilter(EmployeeFilterListType employeeFilterList);

    public Boolean encrypt(boolean encrypt);
}
