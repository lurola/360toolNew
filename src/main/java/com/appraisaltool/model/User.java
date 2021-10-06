package com.appraisaltool.model;

import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "EMPLOYEE")
public class User {	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "userId", nullable = false, updatable = false)
    private Integer userId;
	
	@Column(name = "name", nullable = false)
	private String name;
	
	@Column(name = "surname", nullable = false)
	private String surname;
	
	@Column(name = "email", nullable = false, unique = true)
	private String email;
	
	@Column(name = "password", nullable = false)
	private String password;
	
    @ManyToOne
    @JoinColumn(name = "roleId", insertable = true, updatable = true)
    private Role role;

    @ManyToOne
    @JoinColumn(name = "officeId", insertable = true, updatable = true)
    private Office office;

	@Column(name = "applicationrole", nullable = false)
	@Enumerated(EnumType.STRING)
	private ApplicationRole appRole;
	
	@Column(name = "mentorId", nullable = true)
    private Integer mentorId;

    @ManyToMany
    @JoinTable(name = "EMPLOYEE_TEAM", joinColumns = @JoinColumn(name = "userId"), inverseJoinColumns = @JoinColumn(name = "teamId"))
    private Set<Team> employedTeam;

    @ManyToMany
    @JoinTable(name = "EMPLOYEE_GROUP", joinColumns = @JoinColumn(name = "userId"), inverseJoinColumns = @JoinColumn(name = "groupId"))
    private Set<Group> employedGroup;

    @Deprecated
	public User() {
		this.name="";
		this.surname="";
		this.email="";
		this.password="";
		this.appRole=ApplicationRole.USER;
        this.mentorId = 0;
		
	}
	
}
