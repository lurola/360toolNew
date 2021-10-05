package com.appraisaltool.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appraisaltool.model.UserGroup;
import com.appraisaltool.model.UserGroupId;
import com.appraisaltool.repository.UserGroupRepository;
import com.appraisaltool.service.UserGroupService;

@Service
public class UserGroupServiceImpl implements UserGroupService {
	
	@Autowired UserGroupRepository userGroupRepo;
	
	@Override
	public UserGroup createNewUserGroup(UserGroup userGroup) {
		return userGroupRepo.save(userGroup);
	}
	
	
	public Integer addGroupToaUser(Integer userId, Integer groupId) {
		
		UserGroupId userGroupId = new UserGroupId(userId, groupId);
		
		UserGroup userGroup = new UserGroup();
		userGroup.setUserGroupId(userGroupId);
		userGroup.setGroupId(groupId);
		userGroup.setUserId(userId);
		userGroupRepo.save(userGroup);
		
		return groupId;
	}
	
	
	
	
	public List<Integer> createNewUserGroup(Integer userId, List<Integer> groupIdList) {
		
		UserGroupId userGroupId;
		
		userGroupRepo.deleteAllByUserId(userId);
		
		for(int i=0; i<groupIdList.size(); i++) {
			Integer currGroupId = groupIdList.get(i);
			
			userGroupId = new UserGroupId(userId, currGroupId);
			UserGroup userGroup = new UserGroup();
			userGroup.setUserGroupId(userGroupId);
			userGroup.setGroupId(currGroupId);
			userGroup.setUserId(userId);
			userGroupRepo.save(userGroup);
		}		
		
		return groupIdList;
	}


	public List<Integer> getGroupsByUserId(Integer userId) {
		
		List<Integer> groups = userGroupRepo.getGroupsByUserId(userId);
		
		return groups;
	}
	

}
