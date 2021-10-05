package com.appraisaltool.dto;

import lombok.Data;

@Data
public class AppraiserCountDTO {

    public AppraiserCountDTO() {
        this.appraiserId = 0;
        this.count = 0;
    }

    public AppraiserCountDTO(Integer appraisal, Long count) {
        this.appraiserId = appraisal;
        this.count = new Integer(count.intValue());
    }

	public Integer appraiserId;
	public Integer count;
	
}
