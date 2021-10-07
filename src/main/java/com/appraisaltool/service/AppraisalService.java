package com.appraisaltool.service;

import java.util.List;
import com.appraisaltool.model.Appraisal;

public interface AppraisalService {

	public Appraisal getAppraisalById(Integer id);
	
	public Appraisal createOrUpdateAppraisal(Appraisal id);
	
    public List<Appraisal> assignAppraiserToEmployee(Integer userId);
	
}
