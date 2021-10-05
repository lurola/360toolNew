package com.appraisaltool.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;


@Data
@Entity
@Table (name="GLOBAL_INTERNAL_APPTYPE")
public class InternalGroupAppType {
	
	
	@Id
	private Integer groupId;
	
	
	@Column
	private Integer weight;

}
