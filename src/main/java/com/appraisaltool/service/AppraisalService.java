package com.appraisaltool.service;

import com.appraisaltool.model.Appraisal;

public interface AppraisalService {

	public Appraisal getAppraisalById(Long id);
	
	public Appraisal createOrUpdateAppraisal(Appraisal id);
	
	
}
