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
	
	
	public Long addGroupToaUser(Long userId, Long groupId) {
		
		UserGroupId userGroupId = new UserGroupId(userId, groupId);
		
		UserGroup userGroup = new UserGroup();
		userGroup.setUserGroupId(userGroupId);
		userGroup.setGroupId(groupId);
		userGroup.setUserId(userId);
		userGroupRepo.save(userGroup);
		
		return groupId;
	}
	
	
	
	
	public List<Long> createNewUserGroup(Long userId, List<Long> groupIdList) {
		
		UserGroupId userGroupId;
		
		userGroupRepo.deleteAllByUserId(userId);
		
		for(int i=0; i<groupIdList.size(); i++) {
			Long currGroupId = groupIdList.get(i);
			
			userGroupId = new UserGroupId(userId, currGroupId);
			UserGroup userGroup = new UserGroup();
			userGroup.setUserGroupId(userGroupId);
			userGroup.setGroupId(currGroupId);
			userGroup.setUserId(userId);
			userGroupRepo.save(userGroup);
		}		
		
		return groupIdList;
	}


	public List<Long> getGroupsByUserId(Long userId) {
		
		List<Long> groups = userGroupRepo.getGroupsByUserId(userId);
		
		return groups;
	}
	

}
