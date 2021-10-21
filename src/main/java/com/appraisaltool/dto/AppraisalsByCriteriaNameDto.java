package com.appraisaltool.dto;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AppraisalsByCriteriaNameDto {

    private EmployeeDto appraiser;

    private Integer evalDate;
    private Integer apraisalTypeId;
    private Integer criteriaNameId;

    private List<AppraisalItemDto> appraisalItemDtos;
}
