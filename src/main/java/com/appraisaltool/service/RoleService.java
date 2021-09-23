package com.appraisaltool.service;

import java.util.List;
import com.appraisaltool.model.Role;

public interface RoleService {
	
    public Role createNewRole(String roleName);

    public List<Role> getAllRoles();

    public Role getRoleById(Integer roleId);

}
