package com.appraisaltool.request;

import java.util.Set;
import com.appraisaltool.model.ApplicationRole;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EmployeeRequest {
    private String name;
    private String surname;
    private String email;
    private String password;
    private ApplicationRole appRole;

    private Integer role;
    private Integer office;
    private Integer mentor;
    private Set<Integer> employedGroup;
    private Set<Integer> employedTeam;

}
