package com.appraisaltool.service;

import com.appraisaltool.model.UserGroup;

public interface UserGroupService {
	
	public UserGroup createNewUserGroup(UserGroup userGroup);

    public Integer addGroupToaUser(Integer userId, Integer groupId);
}
