package com.appraisaltool.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.appraisaltool.dto.domain.LookupType;
import com.appraisaltool.mapper.AdministrationMapper;
import com.appraisaltool.response.LookupDataResults;
import com.appraisaltool.service.AdministrationService;
import com.appraisaltool.service.GroupService;
import com.appraisaltool.service.OfficeService;
import com.appraisaltool.service.RoleService;
import com.appraisaltool.service.TeamService;

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

}
