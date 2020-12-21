package com.appraisaltool.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.appraisaltool.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer>{

	public Role getRoleByRoleName(String name);

}
