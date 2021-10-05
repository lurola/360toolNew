package com.appraisaltool.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table (name = "INTERNAL_CRITERIA_SUBTYPE")
public class InternalCriteriaSubtype {


		
	InternalCriteriaSubtype() {
			
	}
		
		
	@Id
	private Integer InternalCriteriaSubtypeId;
		
	@Column
	private Integer language;
		
		
	@Column
	private String InternalCriteriaSubtype;
	
	
	}


