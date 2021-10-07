package com.appraisaltool.service;

import com.appraisaltool.model.Appraisal;

public interface AppraisalService {

	public Appraisal getAppraisalById(Integer id);
	
	public Appraisal createOrUpdateAppraisal(Appraisal id);
	
    public Appraisal assignAppraiserToEmployee(Integer userId);
	
}
