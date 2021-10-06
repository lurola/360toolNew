package com.appraisaltool.service;

import java.util.List;
import com.appraisaltool.model.UserGroup;

public interface UserGroupService {
	
	public UserGroup createNewUserGroup(UserGroup userGroup);

    public List<Integer> createNewUserGroup(Integer userId, List<Integer> groupIdList);

    public Integer addGroupToaUser(Integer userId, Integer groupId);

    public List<Integer> getGroupsByUserId(Integer userId);
}
