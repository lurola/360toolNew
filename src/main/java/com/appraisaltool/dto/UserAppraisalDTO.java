package com.appraisaltool.dto;

import java.util.List;
import lombok.Data;


@Data
public class UserAppraisalDTO {

	private Long appraisalId;
	private String userName;
	private String office;
	private List<String> team;
	private String role;

}