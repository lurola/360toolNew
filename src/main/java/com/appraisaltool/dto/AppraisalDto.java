package com.appraisaltool.dto;

import java.util.List;
import com.appraisaltool.dto.domain.AppraisalTypeType;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AppraisalDto {
    private Integer appraisalId;

    private EmployeeDto evaluatedPerson;

    private EmployeeDto appraiser;

    private Integer evalDate;

    private AppraisalTypeType type;

    private Integer status;

    private List<AppraisalItemDto> apprItemList;

}
