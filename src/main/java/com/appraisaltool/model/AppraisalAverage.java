package com.appraisaltool.model;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table (name = "APPRAISAL_AVERAGES")
public class AppraisalAverage {
	

	@EmbeddedId
	private AppraisalAverageId appAverageId;
	
	@Column
	private Double average;
	
	

}
