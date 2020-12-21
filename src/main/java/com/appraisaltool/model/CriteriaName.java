package com.appraisaltool.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table (name="CRITERIA_NAME")
public class CriteriaName {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long criteriaNameId;
	
	@Column
	private Long appraisalTypeId;
	
	@Column 
	private Long subtypeId;
	
	@Column 
	private Long language;
	
	@Column 
	private String criteriaName;
	
	
}
