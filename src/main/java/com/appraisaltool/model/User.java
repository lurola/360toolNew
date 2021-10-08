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
import com.appraisaltool.dto.domain.EmployeeStatusType;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "EMPLOYEE")
@NoArgsConstructor
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

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private EmployeeStatusType status = EmployeeStatusType.ACTIVE;
	
    @ManyToOne
    @JoinColumn(name = "roleId", insertable = true, updatable = true)
    private Role role;

    @ManyToOne
    @JoinColumn(name = "officeId", insertable = true, updatable = true)
    private Office office;

	@Column(name = "applicationrole", nullable = false)
	@Enumerated(EnumType.STRING)
	private ApplicationRole appRole;

    @ManyToOne
    @JoinColumn(name = "lineManagerId", insertable = true, updatable = true)
    private User lineManager;

    @ManyToOne
    @JoinColumn(name = "teamLeadId", insertable = true, updatable = true)
    private User teamLead;

    @ManyToOne
    @JoinColumn(name = "mentorId", insertable = true, updatable = true)
    private User mentor;

    @Column(name = "isMentor", nullable = false)
    private Boolean isMentor = Boolean.FALSE;

    @Column(name = "isTeamLead", nullable = false)
    private Boolean isTeamLead = false;

    @Column(name = "isLineManager", nullable = false)
    private Boolean isLineManager = false;

    @ManyToMany
    @JoinTable(name = "EMPLOYEE_TEAM", joinColumns = @JoinColumn(name = "userId"), inverseJoinColumns = @JoinColumn(name = "teamId"))
    private Set<Team> employedTeam;

    @ManyToMany
    @JoinTable(name = "EMPLOYEE_GROUP", joinColumns = @JoinColumn(name = "userId"), inverseJoinColumns = @JoinColumn(name = "groupId"))
    private Set<Group> employedGroup;

}
