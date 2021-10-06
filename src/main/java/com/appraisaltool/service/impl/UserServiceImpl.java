package com.appraisaltool.service.impl;


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
import com.appraisaltool.controllerOlder.CurrentUserControllerAdvice;
import com.appraisaltool.dto.ChangePasswordDTO;
import com.appraisaltool.dto.MentorAssignmentDTO;
import com.appraisaltool.dto.NewUserDTO;
import com.appraisaltool.model.User;
import com.appraisaltool.repository.UserGroupRepository;
import com.appraisaltool.repository.UserRepository;
import com.appraisaltool.service.UserGroupService;
import com.appraisaltool.service.UserService;
import com.appraisaltool.service.UserTeamService;

@Service
public class UserServiceImpl implements UserService {

    @Deprecated
	public DozerBeanMapper mapper = new DozerBeanMapper();
	private static final Logger logger = LogManager.getLogger(CurrentUserControllerAdvice.class);
    
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserTeamService userTeamService;
    @Autowired
    private UserGroupRepository userGroupRepo;
    @Autowired
    private UserGroupService userGroupServ;


    /**
     * gets an user by its id
     * @param id
     */
    @Override
    public User getUserByUserId(Integer id) {
        logger.debug("Getting user={}", id);
        return userRepository.findOneByUserId(id);
    }
    
    
    
    public NewUserDTO getUserCreateFormByUserId(Integer userId) {
        logger.debug("Getting userForm={}", userId);
        User user = userRepository.getOne(userId);
        
        NewUserDTO ucFrom = mapper.map(user, NewUserDTO.class);
        List<Integer> userTeamList = userTeamService.getTeamsByUserId(userId);
        List<Integer> userGroupList = userGroupServ.getGroupsByUserId(userId);
        
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
		
        userTeamService.createNewUserTeam(newUser.getUserId(), userCreateFormDto.getTeamId());
		
		userGroupServ.createNewUserGroup(newUser.getUserId(), userCreateFormDto.getGroupId());
				
		return userCreateFormDto;
	}
    
    public User createNewEmployee(User user) {
        return userRepository.save(user);
    }

    
    @Override
	public NewUserDTO updateUser(NewUserDTO userCreateFormDto) {
		
    	//Get the password from db and encrypt it
    	User currentUser = userRepository.getOne(userCreateFormDto.getUserId());
		
    	//Set the same password to the user (as it's empty from update) and save the update user
    	User user = mapper.map(userCreateFormDto, User.class);
    	user.setPassword(currentUser.getPassword());
		User newUser = userRepository.save(user);
        userTeamService.createNewUserTeam(newUser.getUserId(), userCreateFormDto.getTeamId());

		return userCreateFormDto;
	}
    
    public List<Integer> findTeamMates(Integer userId) {
    	return userRepository.findTeamMates(userId);
    }
    
    public List<Integer> findTeamMatesNoGroup(Integer userId) {
    	return userRepository.findTeamMatesNoGroup(userId);
    }
	
    
	/**
	 * finds all users by its office
	 * @param officeId
	 */
	@Override
	public List<User> getUserSByOfficeId(Integer officeId) {
		return userRepository.findAllUsersByOfficeId(officeId);
	}
	

	/**
	 * Get user's mentor by its id
	 * 
	 * @param userId
	 * @return
	 */
	public User getMentor(Integer userId) {
		
		Integer mentorId = getUserByUserId(userId).getMentorId();	
		return getUserByUserId(mentorId);
	}
	
	/**
	 * Calculate the people whose mentor is the one received
	 * @return
	 */
	public List<User> getMentorized(Integer userId) {
		//Recupera todas las personas cuyo mentor es el que recibimos		
		return userRepository.findAllUsersByMentorId(userId);
		
	}

	/**
	 * Get the users for a specific team and role
	 * 
	 * @param teamId
	 * @param role
	 * @return The list of people with a specific role that beIntegers to a team
	 */
    public List<User> getUsersByTeamAndRole(List<Integer> teamId, List<Integer> role) {
		
		return userRepository.getUsersByTeamAndRole(teamId, role);
				
	}
	
	/**
	 * 
	 * @param teamId
	 * @param role
	 * @param userToRemove: Remove the id user in this parameter 
	 * @return
	 */
    public List<User> getUsersByTeamAndRole(List<Integer> teamId, Integer role) {
		
		List<Integer> roleList = new ArrayList<Integer>();
		roleList.add(role);
		return getUsersByTeamAndRole(teamId, roleList);
				
	}
	
	
	/**
	 * 
	 * @return group mates
	 */
	public List<Integer> findGroupMates(Integer userId) {
		return userGroupRepo.findGroupPartners(userId);
		
	}


	/**
	 * 
	 * @param listIdUser
	 * @return
	 */
	public List<User> getUsersInList(List<Integer> listIdUser) {
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
	public List<User> getByQuery(String name, String surname, Integer officeId) {
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
