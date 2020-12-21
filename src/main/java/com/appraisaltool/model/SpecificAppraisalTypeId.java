package com.appraisaltool.model;

import java.io.Serializable;
import javax.persistence.Column;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class SpecificAppraisalTypeId implements Serializable{

	private static final long serialVersionUID = 3233124370476846883L;
	
	@Column (insertable = false, updatable = false)
	private Integer appraisalTypeId;
 
	@Column(insertable = false, updatable = false)
	private Integer subtypeId;
	
	@Column(insertable = false, updatable = false)
	private Integer roleId;
	

	
    public SpecificAppraisalTypeId(Integer appraisalTypeId, String appraisalTypeName, Integer roleId, Integer subtypeId) {
        this.appraisalTypeId = appraisalTypeId;
        this.subtypeId = subtypeId;
        this.roleId = roleId;
    }
    
    public SpecificAppraisalTypeId() {
    	
    }
	
}
