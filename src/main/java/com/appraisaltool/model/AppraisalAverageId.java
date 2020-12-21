package com.appraisaltool.model;

import java.io.Serializable;

import javax.persistence.Column;

import lombok.Getter;
import lombok.Setter;

@Getter  @Setter
public class AppraisalAverageId implements Serializable{

	private static final long serialVersionUID = 3233124370476846883L;
	
	@Column (insertable = false, updatable = false)
	private Long appraisalId;
 
	@Column(insertable = false, updatable = false)
	private Integer appraisalTypeId;
	
	
    public AppraisalAverageId(Long appraisalId, Integer appraisalTypeId) {
        this.appraisalId = appraisalId;
        this.appraisalTypeId = appraisalTypeId;

    }
    
    public AppraisalAverageId() {
    	
    }

}
