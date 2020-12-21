package com.appraisaltool.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class AppraiserCountDTO {

	public AppraiserCountDTO() {
		this.appraiserId = 0L;
		this.count = 0L;
	}
	
	public AppraiserCountDTO(Long appraisal, Long count) {
		this.appraiserId = appraisal;
		this.count = count;
	}
	
	public Long appraiserId;
	public Long count;
	
}
