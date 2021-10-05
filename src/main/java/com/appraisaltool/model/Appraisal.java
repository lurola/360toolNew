package com.appraisaltool.model;

import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table (name = "APPRAISAL")
public class Appraisal {
	
	
	public Appraisal () {}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer appraisalId;
	
	@Column (name = "evaluatedPersonId")
	private Integer evaluatedPersonId;
	
	@Column (name = "appraiserId")
	private Integer appraiserId;
	
	@Column (name = "evalDate")
	private Integer evalDate;
	
	@Column (name = "status")
	private Integer status;

	@OneToMany (mappedBy = "appraisal")
	private List<AppraisalItem> apprItemList;


	public Appraisal (Integer evaluatedPersonId, Integer appraiserId, Integer status, List<AppraisalItem> apprItemList) {
		this.evaluatedPersonId = evaluatedPersonId;
		this.appraiserId = appraiserId;
		
		Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("Europe/Paris"));
		this.evalDate = cal.get(Calendar.YEAR);
		this.status = status;
		this.apprItemList = apprItemList;

	}	
}
