package com.appraisaltool.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class DeprecatedAppItemDTO {

	
	private Integer appraisalId;
	private Integer paramValue01;
	private Integer paramValue02;
	private Integer paramValue03;
	private Integer paramValue04;
	private Integer paramValue05;
	private Integer currentPage;
	
	private boolean editMode;

	
	public boolean isEditMode() {
		return editMode;
	}
	
}
