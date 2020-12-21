package com.appraisaltool.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.appraisaltool.model.InternalGroupAppType;

@Repository
public interface InternalGroupAppTypeRepository extends JpaRepository<InternalGroupAppType, Long>{

	

}
