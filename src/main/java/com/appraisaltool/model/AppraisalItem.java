package com.appraisaltool.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table (name="APPRAISAL_ITEM")
public class AppraisalItem {

	public AppraisalItem () {}
	
	public AppraisalItem (Appraisal app) {
		this.appraisal = app;
	}
	
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long appraisalItemId;
	
	@Column
	private Integer appraisalTypeId;
	
	@Column
	private Integer subtypeId;
	
	@Column
	private Integer paramValue;

	@ManyToOne
    @JoinColumn(name="appraisalId", nullable=false)
	private Appraisal appraisal;
	
	
	public AppraisalItem (Integer appraisalTypeId, Integer subtypeId, Integer paramValue, Appraisal appraisal) {
		
		this.appraisalTypeId = appraisalTypeId;
		this.subtypeId = subtypeId;
		this.paramValue = paramValue;
		this.appraisal = appraisal;
				
	}

}
