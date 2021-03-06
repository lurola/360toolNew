package com.appraisaltool.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.appraisaltool.model.CriteriaName;

@Repository
public interface CriteriaNameRepository extends JpaRepository<CriteriaName, Integer>{
		
	
		public List<CriteriaName> findAllByLanguageOrderByCriteriaNameId(Integer language);
	
	
	}
