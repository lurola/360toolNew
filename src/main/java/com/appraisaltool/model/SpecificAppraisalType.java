package com.appraisaltool.model;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table (name="SPECIFIC_APPRAISAL_TYPE")
public class SpecificAppraisalType {

	@EmbeddedId
	private SpecificAppraisalTypeId specificAppraisalTypeId;
	
	@Column
	private Long weight;
	


	
}
