package com.appraisaltool.dto;

import lombok.Data;

@Data
public class ChangePasswordDTO {

	private String currentPassword;
	private String newPassword;
	private String repeatedPassword;
	private Long userId;
	
}
