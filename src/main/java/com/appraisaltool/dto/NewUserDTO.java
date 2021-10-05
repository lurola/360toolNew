package com.appraisaltool.dto;

import java.util.ArrayList;
import java.util.List;
import javax.validation.constraints.NotEmpty;
import com.appraisaltool.model.ApplicationRole;
import lombok.Getter;
import lombok.Setter;



@Getter @Setter
@Deprecated
public class NewUserDTO {	
	
	
	private Integer userId;
	
	@NotEmpty
	private String name;
	
	@NotEmpty
	private String surname;
	
	@NotEmpty
	private String email;
	
	
	private String password;
	
	
	private Integer roleId;
	
	
	private Integer officeId;
	
	private List<Integer> groupId;
	
	private List<Integer> teamId;
	
	private ApplicationRole appRole;
	
	private Integer mentorId;
	

	public NewUserDTO() {
		this.name="";
		this.surname="";
		this.email="";
		this.password="";
		this.roleId=1;
		this.teamId = new ArrayList<Integer>();
        this.officeId = 0;
		this.appRole=ApplicationRole.USER;
        this.mentorId = 0;
		this.groupId=new ArrayList<Integer>();
		
	}
	
}
