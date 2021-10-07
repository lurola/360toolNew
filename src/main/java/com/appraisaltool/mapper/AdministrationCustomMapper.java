package com.appraisaltool.mapper;

import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import com.appraisaltool.commons.EncryptTool;
import com.appraisaltool.dto.EmployeeFullDetailsDto;
import com.appraisaltool.model.User;

@Mapper
public class AdministrationCustomMapper {

    @AfterMapping
    void afterMapping(@MappingTarget EmployeeFullDetailsDto target, User user) {

        if (user.getLineManager() != null) {
            target.getLineManager().setName(EncryptTool.decode(user.getLineManager().getName()));
            target.getLineManager().setSurname(EncryptTool.decode(user.getLineManager().getSurname()));
        }
        if (user.getTeamLead() != null) {
            target.getTeamLead().setName(EncryptTool.decode(user.getTeamLead().getName()));
            target.getTeamLead().setSurname(EncryptTool.decode(user.getTeamLead().getSurname()));
        }
        if (user.getMentor() != null) {
            target.getMentor().setName(EncryptTool.decode(user.getMentor().getName()));
            target.getMentor().setSurname(EncryptTool.decode(user.getMentor().getSurname()));
        }
    }

}
