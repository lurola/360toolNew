package com.appraisaltool.service;

import java.util.List;
import com.appraisaltool.dto.AppraisalDto;
import com.appraisaltool.dto.AppraiserAssignementDto;
import com.appraisaltool.model.Appraisal;
import com.appraisaltool.request.AppraisalRequest;

public interface AppraisalService {

    public AppraisalDto getAppraisalById(Integer id);
	
    @Deprecated
	public Appraisal createOrUpdateAppraisal(Appraisal id);
	
    public Integer createAppraisal(AppraisalRequest appraisalRequest);

    public void deleteAppraisal(Integer appraisalId);

    /**
     * Create a list of appraisal to the evaluatedPerson the userId (if it is not created previosly) with the next algorithm:
     * <ol>
     * <li>Yourself: userId to userId</li>
     * <li>Line Manager: userId to LineManger (from the user) and LineManger to UserId</li>
     * <li>Team Lead: userId to TeamLead (from the user) and TeamLead to UserId</li>
     * <li>Mentor: userId to Mentor (from the user) and Mentor to UserId</li>
     * <li>TeamMate: user to a random team mate, which doesn't have appraiser by the userId</li>
     * <li>GroupMate: user to a random group mate, which doesn't have appraiser by the userId</li>
     * </ol>
     * 
     * @param userId
     * @param evalDate
     * @return number of the appraisal created
     */
    public Integer assignAppraiserToEmployee(Integer userId, Integer evalDate);


    /**
     * Create a list of appraisal from all the employee from the officeId following the algorithm defined in {@link #assignAppraiserToEmployee(Integer, Integer)}
     * 
     * @param officeId
     * @param evalDate
     * @return
     */
    public Integer assignAppraiserToEmployeeFromOffice(Integer officeId, Integer evalDate);
	
    public List<AppraiserAssignementDto> getAppraiserAssignement();

    public String updateAppraisalValues(AppraisalDto appraisalDto);
}
