package com.appraisaltool.dto;

import com.appraisaltool.dto.domain.AppraisalTypeType;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AppraisalItemDto {

    /*
     * Info related with the appraisal
     */
    private Integer appraisalId;

    private EmployeeDto evaluatedPerson;

    private AppraisalTypeType type;

    private Integer status;

    /*
     * Info related with the appraisal item
     */
    private Integer appraisalItemId;

    private Integer appraisalTypeId;

    private Integer subtypeId;

    private Integer paramValue;
}
