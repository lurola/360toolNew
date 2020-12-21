package com.appraisaltool.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.appraisaltool.model.GlobalAppraisalType;
import com.appraisaltool.model.SpecificAppraisalType;

@Repository
public interface GlobalAppraisalTypeRepository  extends JpaRepository<GlobalAppraisalType, Long>{

	public List<GlobalAppraisalType> findAllByGlobalAppraisalTypeIdRoleId(Integer roleId);

	
	
	
}
