package com.appraisaltool.service.impl;

import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.appraisaltool.dto.EmployeeDto;
import com.appraisaltool.dto.domain.LookupType;
import com.appraisaltool.mapper.AdministrationMapper;
import com.appraisaltool.model.User;
import com.appraisaltool.response.LookupDataResults;
import com.appraisaltool.service.AdministrationService;
import com.appraisaltool.service.GroupService;
import com.appraisaltool.service.OfficeService;
import com.appraisaltool.service.RoleService;
import com.appraisaltool.service.TeamService;
import com.appraisaltool.service.UserService;

@Service
public class AdministrationServiceImpl implements AdministrationService {

    @Autowired
    private RoleService roleService;

    @Autowired
    private OfficeService officeService;

    @Autowired
    private TeamService teamService;

    @Autowired
    private GroupService groupService;

    @Autowired
    private UserService userService;

    @Override
    public LookupDataResults getLookupDataResult(LookupType lookupType) {
        LookupDataResults lookupDataResults = new LookupDataResults();
        lookupDataResults.setLookupName(lookupType.name());

        switch (lookupType) {
            case ROLE:
                lookupDataResults.setResults(AdministrationMapper.INSTANCE.mapRoleList(roleService.getAllRoles()));
                break;
            case OFFICE:
                lookupDataResults.setResults(AdministrationMapper.INSTANCE.mapOfficeList(officeService.getAllOffices()));
                break;
            case TEAM:
                lookupDataResults.setResults(AdministrationMapper.INSTANCE.mapTeamList(teamService.getAllTeams()));
                break;
            case GROUP:
                lookupDataResults.setResults(AdministrationMapper.INSTANCE.mapGroupList(groupService.getAllGroups()));
                break;
            default:
                break;
        }

        return lookupDataResults;
    }

    @Override
    public LookupDataResults getLookupDataResult(LookupType lookupType, Integer id) {
        LookupDataResults lookupDataResults = new LookupDataResults();
        lookupDataResults.setLookupName(lookupType.name());

        switch (lookupType) {
            case ROLE:
                lookupDataResults.setResults(Arrays.asList(AdministrationMapper.INSTANCE.map(roleService.getRoleById(id))));
                break;
            case OFFICE:
                lookupDataResults.setResults(Arrays.asList(AdministrationMapper.INSTANCE.map(officeService.getOfficeById(id))));
                break;
            case TEAM:
                lookupDataResults.setResults(Arrays.asList(AdministrationMapper.INSTANCE.map(teamService.getTeamById(id))));
                break;
            case GROUP:
                lookupDataResults.setResults(Arrays.asList(AdministrationMapper.INSTANCE.map(groupService.getGroupById(id))));
                break;
            default:
                break;
        }

        return lookupDataResults;
    }

    public EmployeeDto getEmployeeById(Integer id) {
        EmployeeDto employeeDto = null;
        
        User user = userService.getUserByUserId(id);

        employeeDto = AdministrationMapper.INSTANCE.map(user);
        employeeDto.setMentor(AdministrationMapper.INSTANCE.mapSummary(userService.getUserByUserId(user.getMentorId())));

        return employeeDto;
    }

    public EmployeeDto getEmployeeSummaryById(Integer id) {
        return AdministrationMapper.INSTANCE.mapSummary(userService.getUserByUserId(id));
    }

    @Override
    public List<EmployeeDto> getEmployeeSummaryByOfficeId(Integer officeId) {
        List<User> list = userService.getUserSByOfficeId(officeId);
        return AdministrationMapper.INSTANCE.mapEmployeeList(list);
    }
}
