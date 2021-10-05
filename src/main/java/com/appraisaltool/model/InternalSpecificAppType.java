package com.appraisaltool.model;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table (name="SPECIFIC_INTERNAL_APPTYPE")
public class InternalSpecificAppType {

	@EmbeddedId
	private InternalSpecificAppTypeId internalSpecificAppTypeId;
	
	@Column
	private Integer weight;
	


	
}
