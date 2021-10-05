package com.appraisaltool.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.appraisaltool.model.AppraisalAverage;

@Repository
public interface AppraisalAverageRepository extends JpaRepository<AppraisalAverage, Integer>{

	public AppraisalAverage getOneByAppAverageIdAppraisalIdAndAppAverageIdAppraisalTypeId(Integer currAppId, Integer appraisalType);
	
	@Query ("SELECT app FROM AppraisalAverage app WHERE app.appAverageId.appraisalId IN (?1) AND app.appAverageId.appraisalTypeId = ?2 ")
	public List<AppraisalAverage> findAllByAppIdListAndAppraisalType(List<Integer> appIdList, Integer appraisalType);


}
