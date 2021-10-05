package com.appraisaltool.model;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Data;

	
@Entity
@Data
@Table(name="EMPLOYEE_GROUP")
public class UserGroup {
	
public UserGroup() {
	
}

@EmbeddedId
private UserGroupId userGroupId;

@Column(name = "userId", nullable = false, insertable = false, updatable = false)
private Integer userId;

@Column(name = "groupId", nullable = false, insertable = false, updatable = false)
private Integer groupId;


	}
