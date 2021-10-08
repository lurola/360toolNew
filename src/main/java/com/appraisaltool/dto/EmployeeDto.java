package com.appraisaltool.dto;

import com.appraisaltool.dto.domain.EmployeeStatusType;
import com.appraisaltool.response.LookupData;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EmployeeDto {
    private Integer userId;
    private String name;
    private String surname;
    private EmployeeStatusType status;

    private LookupData role;
    private LookupData office;

}
