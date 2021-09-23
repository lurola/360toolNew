package com.appraisaltool.service;

import com.appraisaltool.model.UserGroup;

public interface UserGroupService {
	
	public UserGroup createNewUserGroup(UserGroup userGroup);

    public Long addGroupToaUser(Long userId, Long groupId);
}
