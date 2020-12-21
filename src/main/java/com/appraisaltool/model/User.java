package com.appraisaltool.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "EMPLOYEE")
public class User {	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "userId", nullable = false, updatable = false)
	private Long userId;
	
	@Column(name = "name", nullable = false)
	private String name;
	
	@Column(name = "surname", nullable = false)
	private String surname;
	
	@Column(name = "email", nullable = false, unique = true)
	private String email;
	
	@Column(name = "password", nullable = false)
	private String password;
	
	@Column(name = "roleId", nullable = false)
	private Integer roleId;
	
	@Column(name = "officeId", nullable = false)
	private Long officeId;
	
	@Column(name = "applicationrole", nullable = false)
	@Enumerated(EnumType.STRING)
	private ApplicationRole appRole;
	
	@Column(name = "mentorId", nullable = true)
	private Long mentorId;


	public User() {
		this.name="";
		this.surname="";
		this.email="";
		this.password="";
		this.roleId=1;
		this.officeId =1L;
		this.appRole=ApplicationRole.USER;
		this.mentorId=0L;
		
	}
	
}
