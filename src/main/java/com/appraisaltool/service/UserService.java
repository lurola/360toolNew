package com.appraisaltool.service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import com.appraisaltool.dto.NewUserDTO;
import com.appraisaltool.model.User;

public interface UserService {

	public User getUserByUserId(long id);

    public Optional<User> getUserByEmail(String email);

    public Collection<User> getAllUsers();

    public List<User> getUserSByOfficeId(Long officeId);

	public NewUserDTO createNewUser(NewUserDTO user);
	
	public NewUserDTO updateUser(NewUserDTO userCreateForm);

//	List<User> getUsersByTeamId(Long teamId);

//    User createUser(UserCreateForm form);

}
