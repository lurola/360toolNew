package com.appraisaltool.mapper;

import java.util.List;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;
import com.appraisaltool.dto.EmployeeDto;
import com.appraisaltool.model.Group;
import com.appraisaltool.model.Office;
import com.appraisaltool.model.Role;
import com.appraisaltool.model.Team;
import com.appraisaltool.model.User;
import com.appraisaltool.response.LookupData;

@Mapper
public interface AdministrationMapper {
    AdministrationMapper INSTANCE = Mappers.getMapper(AdministrationMapper.class);

    @Mapping(source = "roleId", target = "id")
    @Mapping(source = "roleName", target = "label")
    LookupData map(Role role);

    List<LookupData> mapRoleList(List<Role> roleList);

    @Mapping(source = "officeId", target = "id")
    @Mapping(source = "officeName", target = "label")
    LookupData map(Office office);

    List<LookupData> mapOfficeList(List<Office> officeList);

    @Mapping(source = "teamId", target = "id")
    @Mapping(source = "teamName", target = "label")
    LookupData map(Team team);

    @Mapping(source = "id", target = "teamId")
    @Mapping(source = "label", target = "teamName")
    Team mapToTeam(LookupData lookupData);

    List<LookupData> mapTeamList(List<Team> teamList);

    @Mapping(source = "groupId", target = "id")
    @Mapping(source = "groupName", target = "label")
    LookupData map(Group group);

    @Mapping(source = "id", target = "groupId")
    @Mapping(source = "label", target = "groupName")
    Group mapToGroup(LookupData lookupData);

    List<LookupData> mapGroupList(List<Group> groupList);

    EmployeeDto map(User user);

    @Mapping(source = "employeeDto.role.id", target = "role.roleId")
    @Mapping(source = "employeeDto.office.id", target = "office.officeId")
    @Mapping(source = "employeeDto.mentor.userId", target = "mentorId")
    User map(EmployeeDto employeeDto);

    @Named("mapEmployeeSummary")
    @Mapping(target = "email", ignore = true)
    @Mapping(target = "password", ignore = true)
    @Mapping(target = "appRole", ignore = true)
    @Mapping(target = "employedGroup", ignore = true)
    @Mapping(target = "employedTeam", ignore = true)
    EmployeeDto mapSummary(User user);

    @IterableMapping(qualifiedByName = "mapEmployeeSummary")
    List<EmployeeDto> mapEmployeeList(List<User> userList);
}
