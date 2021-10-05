package com.appraisaltool.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.appraisaltool.model.AppraisalType;

public interface AppraisalTypeRepository extends JpaRepository<AppraisalType, Integer>{

	List<AppraisalType> findByOrderByAppraisalTypeIdAsc();
}
