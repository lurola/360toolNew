package com.appraisaltool.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

@Embeddable
@Getter @Setter
public class UserGroupId implements Serializable{

		/**
		 * 
		 */
		private static final long serialVersionUID = 3233124370476846883L;

		@Column (insertable = false, updatable = false)
		private Long userId;
		
		@Column (insertable = false, updatable = false)
	    private Long groupId;
	 
	    // default constructor
	 
	    public UserGroupId(Long userId, Long groupId) {
	        this.userId = userId;
	        this.groupId = groupId;
	    }
	    
	    public UserGroupId() {
	    	
	    }
	    // getters, equals() and hashCode() methods
	}
