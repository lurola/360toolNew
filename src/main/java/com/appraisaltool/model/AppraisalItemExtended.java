package com.appraisaltool.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AppraisalItemExtended {

    private Integer appraisalId;

    private Integer evaluatedPersonId;

    // private String type;

    private Integer status;

    /*
     * Info related with the appraisal item
     */
    private Integer appraisalItemId;

    // private Integer appraisalTypeId;

    // private Integer subtypeId;

    private Integer paramValue;

}
