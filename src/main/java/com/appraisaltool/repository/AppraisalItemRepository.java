package com.appraisaltool.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.appraisaltool.model.AppraisalItem;
import com.appraisaltool.model.AppraisalItemExtended;

@Repository
public interface AppraisalItemRepository  extends JpaRepository<AppraisalItem, Integer>{

//	public List<AppraisalItem> getAppraisalItemsByAppraisalIdOrderByAppraisalTypeIdAscSubtypeIdAsc(Integer id);
	
	public List<AppraisalItem> findAllByAppraisalOrderByAppraisalTypeIdAscSubtypeIdAsc(Integer id);
	
    @Query("SELECT appItem FROM AppraisalItem appItem WHERE appItem.appraisal.appraisalId = ?1 AND appItem.appraisalTypeId = ?2")
	public List<AppraisalItem> findAppItemsByAppraisalIdAndAppItemType(Integer appId, Integer typeId);
	
	public List<AppraisalItem> findAllByAppraisal(Integer appId);
	
    @Query("SELECT appItem FROM AppraisalItem appItem INNER JOIN  Appraisal app ON (appItem.appraisal.appraisalId = app.appraisalId) WHERE app.evaluatedPerson.userId = ?1 "
			+ "and appItem.appraisalTypeId = ?2 and appItem.subtypeId = ?3")
	public List<AppraisalItem> findAllByEvaluatedPersonIdAndAppraisalTypeIdAndSubtypeId(Integer evalPerson, Integer appraisalType, Integer subtype);

    @Query("SELECT appIt FROM AppraisalItem appIt WHERE appIt.appraisal.appraisalId IN ?1 AND appIt.appraisalTypeId = ?2 AND appIt.subtypeId = ?3 ")
	public List<AppraisalItem> findAllByAppraisalIdListAppraisalTypeAndSubtype(List<Integer> appIdList, Integer appTypeId, Integer subtype);

    @Query("SELECT new com.appraisaltool.model.AppraisalItemExtended(a.appraisalId , a.evaluatedPerson.userId , a.type,   a.status, ai.appraisalItemId , ai.paramValue)"
            + "FROM Appraisal a   INNER JOIN AppraisalItem ai ON ai.appraisal.appraisalId = a.appraisalId "
            + "WHERE a.evalDate =?1 AND a.appraiser.userId = ?2 AND ai.appraisalTypeId = ?3 AND ai.subtypeId =?4")
    public List<AppraisalItemExtended> findAppraisalItemsByEvalDateAppraiserAndCriteriaName(Integer evalDate, Integer appraiserId, Integer appraisalType, Integer subtype);
}
