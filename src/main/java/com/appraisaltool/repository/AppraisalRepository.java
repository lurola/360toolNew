package com.appraisaltool.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.appraisaltool.dto.AppraiserCountDTO;
import com.appraisaltool.model.Appraisal;

@Repository
public interface AppraisalRepository  extends JpaRepository<Appraisal, Long>{

	public Appraisal getAppraisalByAppraisalId(Long id);
	
	public List<Appraisal> findAllByAppraiserId(Long id);
	
	public List<Appraisal> findAllByAppraiserIdAndStatus(Long id, Integer status);
	
	@Query("SELECT new com.appraisaltool.dto.AppraiserCountDTO(u.userId, COUNT(ap.appraiserId)) FROM User u  "
			+ "LEFT JOIN Appraisal ap ON (ap.appraiserId = u.userId) WHERE u.userId IN (?1) group by u.userId")
	public List<AppraiserCountDTO> getNumberOfAppraisalPerAppraiser(List<Long> user);	
	
	@Query("SELECT a.appraiserId FROM Appraisal a WHERE a.evaluatedPersonId = ?1")
	public List<Long> getAppraiserIdByEvaluatedPersonId(Long evaluatedPersonId);
	
	public List<Appraisal> getAppraisalByEvaluatedPersonIdAndStatus(Long userId, Integer status);

	@Query("SELECT a FROM Appraisal a INNER JOIN  User u ON (a.evaluatedPersonId = u.userId) WHERE a.status = ?2 and u.officeId = ?1")
	public List<Appraisal> getAppraisalsByOfficeIdAndStatusId(Long officeId, Integer statusId);
	
	public List<Appraisal> findAllByEvaluatedPersonId(Long evalPersonId);
	
	@Query ("SELECT a.appraisalId FROM Appraisal a WHERE a.evaluatedPersonId = ?1")
	public List<Long> findAllIdsByEvaluatedPersonId(Long evalPersonId);
	
	@Query ("SELECT a.appraisalId FROM Appraisal a WHERE a.evaluatedPersonId = ?1 and status= ?2")
	public List<Long> findAllIdsByEvaluatedPersonIdAndStatus(Long evalPersonId, Integer status);
	
}
