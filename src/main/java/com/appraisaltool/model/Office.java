package com.appraisaltool.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Data
@Table(name = "OFFICE")
@Entity
public class Office {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer officeId;
	
	@Column(name = "OfficeName")
	private String officeName;


}