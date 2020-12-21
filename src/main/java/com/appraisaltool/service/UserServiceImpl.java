package com.appraisaltool.service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.appraisaltool.controller.CurrentUserControllerAdvice;
import com.appraisaltool.dto.ChangePasswordDTO;
import com.appraisaltool.dto.MentorAssignmentDTO;
import com.appraisaltool.dto.NewUserDTO;
import com.appraisaltool.model.User;
import com.appraisaltool.repository.UserGroupRepository;
import com.appraisaltool.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	public DozerBeanMapper mapper = new DozerBeanMapper();
	private static final Logger logger = LogManager.getLogger(CurrentUserControllerAdvice.class);
    
    private final UserRepository userRepository;
    private final UserTeamServiceImpl userTeamServiceImpl;
    private final UserGroupRepository userGroupRepo;
    private final UserGroupServiceImpl userGroupServ;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, UserTeamServiceImpl userTeamServiceImpl, UserGroupRepository userGroupRepo, UserGroupServiceImpl userGroupService) {
        this.userRepository = userRepository;
        this.userTeamServiceImpl = userTeamServiceImpl;
        this.userGroupRepo = userGroupRepo;
        this.userGroupServ = userGroupService;
    }
     

    /**
     * gets an user by its id
     * @param id
     */
    @Override
    public User getUserByUserId(long id) {
        logger.debug("Getting user={}", id);
        return userRepository.findOneByUserId(id);
    }
    
    
    
    public NewUserDTO getUserCreateFormByUserId(long userId) {
        logger.debug("Getting userForm={}", userId);
        User user = userRepository.getOne(userId);
        
        NewUserDTO ucFrom = mapper.map(user, NewUserDTO.class);
        List<Long> userTeamList = userTeamServiceImpl.getTeamsByUserId(userId);
        List<Long> userGroupList = userGroupServ.getGroupsByUserId(userId);
        
        ucFrom.setTeamId(userTeamList);
        ucFrom.setGroupId(userGroupList);
        
        return ucFrom;
    }

    /**
     * Gets an user by its email
     * @param email
     */
    @Override
    public  Optional<User> getUserByEmail(String email) {
        logger.debug("Getting user by email={}", email.replaceFirst("@.*", "@***"));
        return userRepository.findOneByEmail(email);
    }

    /**
     * get al the users
     */
    @Override
    public List<User> getAllUsers() {
        logger.debug("Getting all users");
        return userRepository.findAll();
    }

    /**
     * Creates a new user
     * @param userCreateFormDto
     */
    @Override
	public NewUserDTO createNewUser(NewUserDTO userCreateFormDto) {
    	//Script the password before saving it in the database
    	
		userCreateFormDto.setPassword(new BCryptPasswordEncoder().encode(userCreateFormDto.getPassword()));
		User user = mapper.map(userCreateFormDto, User.class);
		
		User newUser = userRepository.save(user);
		
		userTeamServiceImpl.createNewUserTeam(newUser.getUserId(), userCreateFormDto.getTeamId());
		
		userGroupServ.createNewUserGroup(newUser.getUserId(), userCreateFormDto.getGroupId());
				
		return userCreateFormDto;
	}
    
    
    @Override
	public NewUserDTO updateUser(NewUserDTO userCreateFormDto) {
		
    	//Get the password from db and encrypt it
    	User currentUser = userRepository.getOne(userCreateFormDto.getUserId());
		
    	//Set the same password to the user (as it's empty from update) and save the update user
    	User user = mapper.map(userCreateFormDto, User.class);
    	user.setPassword(currentUser.getPassword());
		User newUser = userRepository.save(user);
		userTeamServiceImpl.createNewUserTeam(newUser.getUserId(), userCreateFormDto.getTeamId());

		return userCreateFormDto;
	}
    
    public List<Long> findTeamMates(Long userId) {
    	return userRepository.findTeamMates(userId);
    }
    
    public List<Long> findTeamMatesNoGroup(Long userId) {
    	return userRepository.findTeamMatesNoGroup(userId);
    }
	
    
	/**
	 * finds all users by its office
	 * @param officeId
	 */
	@Override
	public List<User> getUserSByOfficeId(Long officeId) {
		return userRepository.findAllUsersByOfficeId(officeId);
	}
	

	/**
	 * Get user's mentor by its id
	 * 
	 * @param userId
	 * @return
	 */
	public User getMentor(Long userId) {
		
		Long mentorId = getUserByUserId(userId).getMentorId();	
		return getUserByUserId(mentorId);
	}
	
	/**
	 * Calculate the people whose mentor is the one received
	 * @return
	 */
	public List<User> getMentorized(Long userId) {
		//Recupera todas las personas cuyo mentor es el que recibimos		
		return userRepository.findAllUsersByMentorId(userId);
		
	}

	/**
	 * Get the users for a specific team and role
	 * 
	 * @param teamId
	 * @param role
	 * @return The list of people with a specific role that belongs to a team
	 */
	public List<User> getUsersByTeamAndRole(List<Long> teamId, List<Integer> role) {
		
		return userRepository.getUsersByTeamAndRole(teamId, role);
				
	}
	
	/**
	 * 
	 * @param teamId
	 * @param role
	 * @param userToRemove: Remove the id user in this parameter 
	 * @return
	 */
	public List<User> getUsersByTeamAndRole(List<Long> teamId, Integer role) {
		
		List<Integer> roleList = new ArrayList<Integer>();
		roleList.add(role);
		return getUsersByTeamAndRole(teamId, roleList);
				
	}
	
	
	/**
	 * 
	 * @return group mates
	 */
	public List<Long> findGroupMates(Long userId) {
		return userGroupRepo.findGroupPartners(userId);
		
	}


	/**
	 * 
	 * @param listIdUser
	 * @return
	 */
	public List<User> getUsersInList(List<Long> listIdUser) {
		return userRepository.getUsersInList(listIdUser);
		
	}
	
	/**
	 * 
	 * @param user
	 * @return
	 */
	public List<User> searchUser(User user) {
		//TODO: call the searchUser method
//		return userRepository.searchUser(user);
		return null;
		
		
	}

	
	/**
	 * 
	 * @param name
	 * @param surname
	 * @param officeId
	 * @return
	 */
	public List<User> getByQuery(String name, String surname, Long officeId) {
		return userRepository.getByQuery(name, surname, officeId);
	}
	
	
	public Boolean assignMentor(MentorAssignmentDTO mentorAssigDto) {
		
		User currUser = getUserByUserId(mentorAssigDto.getUserId());
		currUser.setMentorId(mentorAssigDto.getMentorUserId());
		
		userRepository.save(currUser);
		
		return null;
	}


	public void changePassword(@Valid ChangePasswordDTO chPasswordDto) {
		
		User user = userRepository.findOneByUserId(chPasswordDto.getUserId());
		
		String encryptedNewPassword = new BCryptPasswordEncoder().encode(chPasswordDto.getNewPassword());
		
		user.setPassword(encryptedNewPassword);
		
		userRepository.save(user);
		
	}


	public Boolean initilizePassword(@Valid ChangePasswordDTO usechPasswordDtorId) {
		
		User user = userRepository.findOneByUserId(usechPasswordDtorId.getUserId());
		
		String dbPassword = ""; 
		String newPassword = usechPasswordDtorId.getNewPassword();
		String repeatedPassword = usechPasswordDtorId.getRepeatedPassword();

		if(user != null) {
			dbPassword = user.getPassword();
	
			if(newPassword != null && repeatedPassword != null) {
				if(newPassword.equals(repeatedPassword)) {
										
					final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
					
					if(passwordEncoder.matches(usechPasswordDtorId.getCurrentPassword(), dbPassword)) {
						//Todo ha sido correcto, se guarda la nueva contraseña en bbdd.
						
						newPassword = new BCryptPasswordEncoder().encode(newPassword);
						
						user.setPassword(newPassword);
						userRepository.save(user);
						
						return true;
					}
				}
			}
		}
		
		//Algo ha fallado, no se guarda la nueva contraseña en base de datos
		return false;
	}

}
