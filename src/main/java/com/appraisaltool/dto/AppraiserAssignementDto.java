package com.appraisaltool.dto;

import lombok.Data;

@Data
public class AppraiserAssignementDto {

    private Integer evalDate;
    private EmployeeDto appraiser;

    private AppraiserAssignementItemDto youself;
    private AppraiserAssignementItemDto lineManager;
    private AppraiserAssignementItemDto teamLead;
    private AppraiserAssignementItemDto mentor;
    private AppraiserAssignementItemDto teamMate;
    private AppraiserAssignementItemDto groupMate;
}
