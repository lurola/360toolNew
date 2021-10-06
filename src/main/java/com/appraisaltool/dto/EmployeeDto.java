package com.appraisaltool.dto;

import java.util.Set;
import com.appraisaltool.model.ApplicationRole;
import com.appraisaltool.response.LookupData;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EmployeeDto {

    private Integer userId;
    private String name;
    private String surname;
    private String email;
    private String password;
    private ApplicationRole appRole;

    private LookupData role;
    private LookupData office;
    private EmployeeDto mentor;
    private Set<LookupData> employedGroup;
    private Set<LookupData> employedTeam;


}
