package com.appraisaltool.service.impl;

import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.appraisaltool.commons.EncryptTool;
import com.appraisaltool.dto.EmployeeDto;
import com.appraisaltool.dto.domain.LookupType;
import com.appraisaltool.mapper.AdministrationMapper;
import com.appraisaltool.model.User;
import com.appraisaltool.request.EmployeeRequest;
import com.appraisaltool.response.GGResponse;
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

    @Override
    public EmployeeDto createEmployee(EmployeeRequest employeeRequest) {
        User newUser = userService.createNewEmployee(AdministrationMapper.INSTANCE.map(employeeRequest));
        return getEmployeeById(newUser.getUserId());
    }

    @Override
    public EmployeeDto updateEmployee(EmployeeRequest employeeRequest) {
        User newUser = userService.updateUser(AdministrationMapper.INSTANCE.map(employeeRequest));
        return getEmployeeById(newUser.getUserId());
    }

    public GGResponse<EmployeeDto> login(String email, String password) {
        GGResponse<EmployeeDto> response = new GGResponse<EmployeeDto>(null, null, false);

        User user = userService.getUserByEmail(EncryptTool.encode(email)).orElse(null);
        if (user == null) {
            response.setErrors(Arrays.asList("No user register with this email"));
            return response;
        }
        if (user.getPassword().compareTo(EncryptTool.encode(password)) != 0) {
            response.setErrors(Arrays.asList("Wrong pass"));
        }
        response.setData(AdministrationMapper.INSTANCE.map(user));
        response.setSuccess(true);

        return response;
    }
}
