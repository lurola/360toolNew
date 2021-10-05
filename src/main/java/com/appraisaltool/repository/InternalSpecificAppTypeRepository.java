package com.appraisaltool.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.appraisaltool.model.InternalSpecificAppType;

@Repository
public interface InternalSpecificAppTypeRepository extends JpaRepository<InternalSpecificAppType, Integer>{

	public List<InternalSpecificAppType> findAllByInternalSpecificAppTypeIdRoleIdAndInternalSpecificAppTypeIdGroupId(Integer roleId, Integer groupId);
	
	public List<InternalSpecificAppType> findAllByInternalSpecificAppTypeIdRoleId(Integer roleId);
	

}
