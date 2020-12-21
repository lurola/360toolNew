package com.appraisaltool.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table (name="APPRAISAL_TYPE")
public class AppraisalType {

	@Id
	private Long appraisalTypeId;
	
	@Column
	private String appraisalTypeName;
	
}
