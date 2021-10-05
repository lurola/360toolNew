package com.appraisaltool.dto;

import lombok.Data;

@Data
public class AppraisalHeaderDTO {
	
	private Integer appraisalId;
	private String evaluatedPersonName; 
	private String appraiserName;
	private Double average;
	private Integer highAverage;
	private String highSubject;
	
}
