package com.appraisaltool.model;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="EMPLOYEE_TEAM")
public class UserTeam {
	public UserTeam() {
		
	}

	@EmbeddedId
	private UserTeamId userTeamId;
	
	@Column(name = "userId", nullable = false, insertable = false, updatable = false)
	private Long userId;
	
	@Column(name = "teamId", nullable = false, insertable = false, updatable = false)
    private Long teamId;


}
