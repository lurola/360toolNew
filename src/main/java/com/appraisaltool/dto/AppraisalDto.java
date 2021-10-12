package com.appraisaltool.dto;

import java.util.List;
import com.appraisaltool.dto.domain.AppraisalTypeType;
import lombok.Data;

@Data
public class AppraisalDto {
    private Integer appraisalId;

    private EmployeeDto evaluatedPerson;

    private EmployeeDto appraiser;

    private Integer evalDate;

    private AppraisalTypeType type;

    private Integer status;

    private List<AppraisalItemDto> apprItemList;

}
