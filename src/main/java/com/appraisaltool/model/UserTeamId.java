package com.appraisaltool.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

@Embeddable
@Getter @Setter
public class UserTeamId implements Serializable{

	/**
	 * 
	 */
	private static final Long serialVersionUID = 3233124370476846883L;

	@Column (insertable = false, updatable = false)
	private Integer userId;
	
	@Column (insertable = false, updatable = false)
    private Integer teamId;
 
    // default constructor
 
    public UserTeamId(Integer userId, Integer teamId) {
        this.userId = userId;
        this.teamId = teamId;
    }
    
    public UserTeamId() {	
    }

}