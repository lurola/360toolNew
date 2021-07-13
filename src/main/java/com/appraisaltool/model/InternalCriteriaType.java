package com.appraisaltool.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table (name = "INTERNAL_CRITERIA_TYPE")
public class InternalCriteriaType {

	
	InternalCriteriaType() {
		
	}
	
	
	@Id
	private Long InternalCriteriaTypeId;
	
	@Column
	private Long language;
	
	
	@Column
	private String InternalCriteriaType;
}
