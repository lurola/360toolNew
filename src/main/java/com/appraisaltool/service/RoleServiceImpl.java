package com.appraisaltool.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.appraisaltool.model.Role;
import com.appraisaltool.repository.RoleRepository;

@Service
public class RoleServiceImpl implements RoleService{

	@Autowired private RoleRepository roleRepository;
	
	private static final Logger logger = LogManager.getLogger(OfficeServiceImp.class);
	
	/**
	 * Get one role by its id
	 * @param id
	 */
	public Role getRoleById(@PathVariable(value = "id") Integer roleId)  {
		logger.debug("[OfficeServiceImp] calling getOfficeById");
		Role role = roleRepository.getOne(roleId);
		return role;
	}

	/**
	 * Get one role by its ID
	 * @param name
	 */
	public Role getRoleByName(@PathVariable(value = "name") String name) {

		Role role = roleRepository.getRoleByRoleName(name);
		return role;
	}

	/**
	 * Get all the roles 
	 */
	public List<Role> getAllRoles() {
		logger.debug("[OfficeServiceImp] calling getAllOffices");
		return roleRepository.findAll();
	}

	/**
	 * Creates a new Role
	 *@param role
	 */
	public Role createNewRole(Role role) {
		logger.debug("[OfficeServiceImp] calling createNewOffice");
		return roleRepository.save(role);
	}
	
	/**
	 * Creates a new Role
	 *@param role
	 */
	public Role createNewRole(String roleName) {
		Role  role = new Role();
		role.setRoleName(roleName);
		return roleRepository.save(role);
	}
	
	
	
	/**
	 * Deletes a Role by its ID
	 * @param roleID
	 */
	public void deleteRole(Integer roleID) {
		logger.debug("[OfficeServiceImp] calling createNewOffice");
		roleRepository.deleteById(roleID);
	}

	
}
