package com.appraisaltool.mapper;

import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import com.appraisaltool.dto.AppraisalDto;
import com.appraisaltool.model.Appraisal;
import com.appraisaltool.model.AppraisalItem;

@Mapper
public class AppraisalCustomMapper {
    @AfterMapping
    void afterMapping(@MappingTarget Appraisal target, AppraisalDto appraisalDto) {

        for (AppraisalItem appItem : target.getApprItemList()) {
            appItem.setAppraisal(target);
        }
    }
}
