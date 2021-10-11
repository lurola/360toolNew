package com.appraisaltool.request;

import com.appraisaltool.dto.domain.AppraisalTypeType;
import lombok.Data;

@Data
public class AppraisalRequest {

    private Integer evalDate;
    private Integer evaluatedPersonId;
    private Integer appraiserId;
    private AppraisalTypeType type;
}
