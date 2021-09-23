package com.appraisaltool.service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import com.appraisaltool.dto.ChangePasswordDTO;
import com.appraisaltool.dto.MentorAssignmentDTO;
import com.appraisaltool.dto.NewUserDTO;
import com.appraisaltool.model.User;

public interface UserService {

	public User getUserByUserId(long id);

    public Optional<User> getUserByEmail(String email);

    public Collection<User> getAllUsers();

    public List<User> getUserSByOfficeId(Long officeId);

	public NewUserDTO createNewUser(NewUserDTO user);
	
	public NewUserDTO updateUser(NewUserDTO userCreateForm);

    public NewUserDTO getUserCreateFormByUserId(long userId);

    public void changePassword(ChangePasswordDTO chPasswordDto);

    public List<User> getByQuery(String name, String surname, Long officeId);

    public Boolean assignMentor(MentorAssignmentDTO mentorAssigDto);

    public Boolean initilizePassword(ChangePasswordDTO usechPasswordDtorId);

//	List<User> getUsersByTeamId(Long teamId);

//    User createUser(UserCreateForm form);

}
