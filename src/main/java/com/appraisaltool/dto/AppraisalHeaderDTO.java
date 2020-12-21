package com.appraisaltool.dto;

import lombok.Data;

@Data
public class AppraisalHeaderDTO {
	
	private Long appraisalId;
	private String evaluatedPersonName; 
	private String appraiserName;
	private Double average;
	private Long highAverage;
	private String highSubject;
	
}
