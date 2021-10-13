package com.appraisaltool.dto;

import java.util.List;
import com.appraisaltool.response.LookupData;
import lombok.Data;

@Data
public class AppraisalTypeDto {

    private Integer id;

    private String label;

    private List<LookupData> criteriaNameList;

}
