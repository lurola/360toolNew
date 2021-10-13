package com.appraisaltool.model;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table (name="APPRAISAL_TYPE")
public class AppraisalType {

	@Id
	private Integer appraisalTypeId;
	
	@Column
	private String appraisalTypeName;
	
    @OneToMany(mappedBy = "appraisalType")
    private List<CriteriaName> criteriaNameList;
}
