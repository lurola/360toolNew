package com.appraisaltool.mapper;

import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import com.appraisaltool.commons.EncryptTool;
import com.appraisaltool.dto.AppraisalDto;
import com.appraisaltool.dto.AppraisalItemDto;
import com.appraisaltool.dto.AppraiserAssignementDto;
import com.appraisaltool.model.Appraisal;
import com.appraisaltool.model.AppraisalItem;
import com.appraisaltool.model.AppraiserAssignement;

@Mapper(imports = {
        EncryptTool.class}, uses = AppraisalCustomMapper.class)
public interface AppraisalMapper {
    AppraisalMapper INSTANCE = Mappers.getMapper(AppraisalMapper.class);

    @Mapping(source = "userId", target = "appraiser.userId")
    @Mapping(expression = "java(EncryptTool.decode(appraiserAssignement.getName()))", target = "appraiser.name")
    @Mapping(expression = "java(EncryptTool.decode(appraiserAssignement.getSurname()))", target = "appraiser.surname")
    @Mapping(source = "yourselfAppraisalfId", target = "youself.appraisalId")
    @Mapping(source = "yourselfStatus", target = "youself.status")
    @Mapping(source = "userId", target = "youself.userId")
    @Mapping(expression = "java(EncryptTool.decode(appraiserAssignement.getName()))", target = "youself.name")
    @Mapping(expression = "java(EncryptTool.decode(appraiserAssignement.getSurname()))", target = "youself.surname")
    @Mapping(source = "lineManagerAppraisalId", target = "lineManager.appraisalId")
    @Mapping(source = "lineManagerStatus", target = "lineManager.status")
    @Mapping(source = "lineManagerEvaluatedPersonId", target = "lineManager.userId")
    @Mapping(expression = "java(EncryptTool.decode(appraiserAssignement.getLineManagerName()))", target = "lineManager.name")
    @Mapping(expression = "java(EncryptTool.decode(appraiserAssignement.getLineManagerSurname()))", target = "lineManager.surname")
    @Mapping(source = "teamLeadAppraisalId", target = "teamLead.appraisalId")
    @Mapping(source = "teamLeadStatus", target = "teamLead.status")
    @Mapping(source = "teamLeadEvaluatedPersonId", target = "teamLead.userId")
    @Mapping(expression = "java(EncryptTool.decode(appraiserAssignement.getTeamLeadName()))", target = "teamLead.name")
    @Mapping(expression = "java(EncryptTool.decode(appraiserAssignement.getTeamLeadSurname()))", target = "teamLead.surname")
    @Mapping(source = "mentorAppraisalId", target = "mentor.appraisalId")
    @Mapping(source = "mentorStatus", target = "mentor.status")
    @Mapping(source = "mentorEvaluatedPersonId", target = "mentor.userId")
    @Mapping(expression = "java(EncryptTool.decode(appraiserAssignement.getMentorName()))", target = "mentor.name")
    @Mapping(expression = "java(EncryptTool.decode(appraiserAssignement.getMentorSurname()))", target = "mentor.surname")
    @Mapping(source = "teamAppraisalId", target = "teamMate.appraisalId")
    @Mapping(source = "teamStatus", target = "teamMate.status")
    @Mapping(source = "teamEvaluatedPersonId", target = "teamMate.userId")
    @Mapping(expression = "java(EncryptTool.decode(appraiserAssignement.getTeamName()))", target = "teamMate.name")
    @Mapping(expression = "java(EncryptTool.decode(appraiserAssignement.getTeamSurname()))", target = "teamMate.surname")
    @Mapping(source = "groupAppraisalId", target = "groupMate.appraisalId")
    @Mapping(source = "groupStatus", target = "groupMate.status")
    @Mapping(source = "groupEvaluatedPersonId", target = "groupMate.userId")
    @Mapping(expression = "java(EncryptTool.decode(appraiserAssignement.getGroupName()))", target = "groupMate.name")
    @Mapping(expression = "java(EncryptTool.decode(appraiserAssignement.getGroupSurname()))", target = "groupMate.surname")
    AppraiserAssignementDto map(AppraiserAssignement appraiserAssignement);

    List<AppraiserAssignementDto> mapAppraiserAssignementList(List<AppraiserAssignement> appraiserAssignementList);

    AppraisalItemDto map(AppraisalItem appraisalItem);

    List<AppraisalItemDto> mapAppraisalItemList(List<AppraisalItem> appraisalItemList);

    AppraisalDto map(Appraisal appraisal);

    List<AppraisalDto> mapAppraisalList(List<Appraisal> appraisalList);

    Appraisal map(AppraisalDto appraisalDto);

}
