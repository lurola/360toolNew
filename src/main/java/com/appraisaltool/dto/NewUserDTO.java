package com.appraisaltool.dto;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotEmpty;

import com.appraisaltool.model.ApplicationRole;

import lombok.Getter;
import lombok.Setter;



@Getter @Setter
public class NewUserDTO {	
	
	
	private Long userId;
	
	@NotEmpty
	private String name;
	
	@NotEmpty
	private String surname;
	
	@NotEmpty
	private String email;
	
	
	private String password;
	
	
	private Integer roleId;
	
	
	private Long officeId;
	
	private List<Long> groupId;
	
	private List<Long> teamId;
	
	private ApplicationRole appRole;
	
	private Long mentorId;
	

	public NewUserDTO() {
		this.name="";
		this.surname="";
		this.email="";
		this.password="";
		this.roleId=1;
		this.teamId = new ArrayList<Long>();
		this.officeId =0L;
		this.appRole=ApplicationRole.USER;
		this.mentorId=0L;
		this.groupId=new ArrayList<Long>();
		
	}
	
}
