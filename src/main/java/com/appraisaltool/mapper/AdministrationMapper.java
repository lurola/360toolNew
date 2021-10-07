package com.appraisaltool.mapper;

import java.util.List;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;
import com.appraisaltool.commons.EncryptTool;
import com.appraisaltool.dto.EmployeeDto;
import com.appraisaltool.dto.EmployeeFullDetailsDto;
import com.appraisaltool.model.Group;
import com.appraisaltool.model.Office;
import com.appraisaltool.model.Role;
import com.appraisaltool.model.Team;
import com.appraisaltool.model.User;
import com.appraisaltool.request.EmployeeRequest;
import com.appraisaltool.response.LookupData;

@Mapper(imports = {
        EncryptTool.class}, uses = AdministrationCustomMapper.class)
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

    @Mapping(source = "value", target = "teamId")
    Team mapIntegerToTeam(Integer value);

    @Mapping(source = "value", target = "groupId")
    Group mapIntegerToGroup(Integer value);

    List<LookupData> mapTeamList(List<Team> teamList);

    @Mapping(source = "groupId", target = "id")
    @Mapping(source = "groupName", target = "label")
    LookupData map(Group group);

    @Mapping(source = "id", target = "groupId")
    @Mapping(source = "label", target = "groupName")
    Group mapToGroup(LookupData lookupData);

    List<LookupData> mapGroupList(List<Group> groupList);

    @Mapping(expression = "java(EncryptTool.encode(employeeRequest.getName()))", target = "name")
    @Mapping(expression = "java(EncryptTool.encode(employeeRequest.getSurname()))", target = "surname")
    @Mapping(expression = "java(EncryptTool.encode(employeeRequest.getEmail()))", target = "email")
    @Mapping(expression = "java(EncryptTool.encode(employeeRequest.getPassword()))", target = "password")
    @Mapping(source = "employeeRequest.role", target = "role.roleId")
    @Mapping(source = "employeeRequest.office", target = "office.officeId")
    @Mapping(source = "employeeRequest.lineManager", target = "lineManager.userId")
    @Mapping(source = "employeeRequest.teamLead", target = "teamLead.userId")
    @Mapping(source = "employeeRequest.mentor", target = "mentor.userId")
    User map(EmployeeRequest employeeRequest);


    @Mapping(expression = "java(EncryptTool.decode(user.getName()))", target = "name")
    @Mapping(expression = "java(EncryptTool.decode(user.getSurname()))", target = "surname")
    @Mapping(expression = "java(EncryptTool.decode(user.getEmail()))", target = "email")
    @Mapping(expression = "java(EncryptTool.decode(user.getPassword()))", target = "password")
    EmployeeFullDetailsDto map(User user);

    @Named("mapEmployeeSummary")
    @Mapping(expression = "java(EncryptTool.decode(user.getName()))", target = "name")
    @Mapping(expression = "java(EncryptTool.decode(user.getSurname()))", target = "surname")
    EmployeeDto mapSummary(User user);

    @IterableMapping(qualifiedByName = "mapEmployeeSummary")
    List<EmployeeDto> mapEmployeeList(List<User> userList);

}
