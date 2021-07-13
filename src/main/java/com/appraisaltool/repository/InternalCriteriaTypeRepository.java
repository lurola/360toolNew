package com.appraisaltool.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.appraisaltool.model.InternalCriteriaType;

public interface InternalCriteriaTypeRepository extends JpaRepository<InternalCriteriaType, Long> {
	
	public List<InternalCriteriaType> getInternalCriteriaTypeByLanguage(Long language);

}
