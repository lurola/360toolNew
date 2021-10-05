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
	private Integer criteriaNameId;
	
	@Column
	private Integer appraisalTypeId;
	
	@Column 
	private Integer subtypeId;
	
	@Column 
	private Integer language;
	
	@Column 
	private String criteriaName;
	
	
}
