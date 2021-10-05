package com.appraisaltool.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.appraisaltool.model.SpecificAppraisalType;

@Repository
public interface SpecificAppraisalTypeRepository  extends JpaRepository<SpecificAppraisalType, Integer>{


	public List<SpecificAppraisalType> findAllBySpecificAppraisalTypeIdRoleId(Integer roleId);
	
	
}
