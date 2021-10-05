package com.appraisaltool.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.appraisaltool.model.InternalCriteriaSubtype;

public interface InternalCriteriaSubtypeRepository extends JpaRepository <InternalCriteriaSubtype, Integer> {
	
	public List<InternalCriteriaSubtype> getInternalCriteriaSubypeByLanguage(Integer language);

}
