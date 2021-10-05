package com.appraisaltool.model;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Data;


@Data
@Entity
@Table (name="GLOBAL_APPRAISAL_TYPE")
public class GlobalAppraisalType {
	
	
	@EmbeddedId
	private GlobalAppraisalTypeId globalAppraisalTypeId;
	
	
	@Column
	private Integer weight;

}
