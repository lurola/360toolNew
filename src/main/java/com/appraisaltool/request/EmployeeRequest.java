package com.appraisaltool.request;

import java.util.Set;
import com.appraisaltool.dto.domain.EmployeeStatusType;
import com.appraisaltool.model.ApplicationRole;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EmployeeRequest {
    private Integer userId;
    private String name;
    private String surname;
    private String email;
    private String password;
    private ApplicationRole appRole;
    private EmployeeStatusType status;

    private Integer role;
    private Integer office;
    private Integer lineManager;
    private Integer teamLead;
    private Integer mentor;

    private Boolean isLineManager;
    private Boolean isTeamLead;
    private Boolean isMentor;

    private Set<Integer> employedGroup;
    private Set<Integer> employedTeam;

}
