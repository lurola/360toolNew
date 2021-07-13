package com.appraisaltool.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.appraisaltool.model.AppraisalItem;

@Repository
public interface AppraisalItemRepository  extends JpaRepository<AppraisalItem, Long>{

//	public List<AppraisalItem> getAppraisalItemsByAppraisalIdOrderByAppraisalTypeIdAscSubtypeIdAsc(Long id);
	
	public List<AppraisalItem> findAllByAppraisalOrderByAppraisalTypeIdAscSubtypeIdAsc(Long id);
	
	@Query("SELECT appItem FROM AppraisalItem appItem WHERE appItem.appraisal = ?1 AND appItem.appraisalTypeId = ?2")
	public List<AppraisalItem> findAppItemsByAppraisalIdAndAppItemType(Long appId, Integer typeId);
	
	public List<AppraisalItem> findAllByAppraisal(Long appId);
	
	@Query("SELECT appItem FROM AppraisalItem appItem INNER JOIN  Appraisal app ON (appItem.appraisal = app.appraisalId) WHERE app.evaluatedPersonId = ?1 "
			+ "and appItem.appraisalTypeId = ?2 and appItem.subtypeId = ?3")
	public List<AppraisalItem> findAllByEvaluatedPersonIdAndAppraisalTypeIdAndSubtypeId(Integer evalPerson, Long appraisalType, Integer subtype);

	@Query ("SELECT appIt FROM AppraisalItem appIt WHERE appIt.appraisal IN ?1 AND appIt.appraisalTypeId = ?2 AND appIt.subtypeId = ?3 ")
	public List<AppraisalItem> findAllByAppraisalIdListAppraisalTypeAndSubtype(List<Long> appIdList, Integer appTypeId, Integer subtype);
}
