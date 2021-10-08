package com.appraisaltool.dto;

import java.util.Set;
import com.appraisaltool.dto.domain.EmployeeStatusType;
import com.appraisaltool.model.ApplicationRole;
import com.appraisaltool.response.LookupData;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EmployeeFullDetailsDto {

    private Integer userId;
    private String name;
    private String surname;
    private String email;
    private String password;
    private ApplicationRole appRole;

    private EmployeeStatusType status;

    private LookupData role;
    private LookupData office;
    private EmployeeDto lineManager;
    private EmployeeDto teamLead;
    private EmployeeDto mentor;

    private Boolean isLineManager;
    private Boolean isTeamLead;
    private Boolean isMentor;

    private Set<LookupData> employedGroup;
    private Set<LookupData> employedTeam;

}
