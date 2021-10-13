package com.appraisaltool.controller;

import static com.appraisaltool.commons.Constants.ACCEPT_APPLICATION_JSON;
import static com.appraisaltool.commons.Constants.MAPPING_APPRAISAL_TOOL;
import static com.appraisaltool.commons.Constants.TAG_ADMIN;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.appraisaltool.dto.AppraisalTypeDto;
import com.appraisaltool.dto.EmployeeDto;
import com.appraisaltool.dto.EmployeeFullDetailsDto;
import com.appraisaltool.dto.domain.EmployeeFilterListType;
import com.appraisaltool.dto.domain.LookupType;
import com.appraisaltool.request.EmployeeRequest;
import com.appraisaltool.request.LoginRequest;
import com.appraisaltool.response.GGResponse;
import com.appraisaltool.response.LookupDataResults;
import com.appraisaltool.service.AdministrationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = {
        "http://localhost:4200", "http://localhost:4201"}, maxAge = 3600)
@RestController
@RequestMapping(value = MAPPING_APPRAISAL_TOOL + "/" + TAG_ADMIN)
@Api(value = "Administration and utils functions", tags = TAG_ADMIN, description = "Administration and utils functions")
public class AdministrationController {

    @Autowired
    private AdministrationService administrationService;

    @ApiOperation(tags = TAG_ADMIN, value = "Get Lookups values")
    @RequestMapping(value = "/lookup/{lookupType}", produces = {
            MediaType.APPLICATION_JSON_VALUE}, headers = ACCEPT_APPLICATION_JSON, method = RequestMethod.GET)
    public ResponseEntity<GGResponse<LookupDataResults>> getLookup(@PathVariable("lookupType") LookupType lookupType) {
        LookupDataResults lookupDataResults = administrationService.getLookupDataResult(lookupType);

        return new ResponseEntity<GGResponse<LookupDataResults>>( new GGResponse<LookupDataResults>(lookupDataResults, null, true), HttpStatus.OK);
    }

    @ApiOperation(tags = TAG_ADMIN, value = "Get Lookup value")
    @RequestMapping(value = "/lookup/{lookupType}/{id}", produces = {
            MediaType.APPLICATION_JSON_VALUE}, headers = ACCEPT_APPLICATION_JSON, method = RequestMethod.GET)
    public ResponseEntity<GGResponse<LookupDataResults>> getLookupById(@PathVariable("lookupType") LookupType lookupType, @PathVariable("id") Integer id) {
        LookupDataResults lookupDataResults = administrationService.getLookupDataResult(lookupType, id);

        return new ResponseEntity<GGResponse<LookupDataResults>>(new GGResponse<LookupDataResults>(lookupDataResults, null, true), HttpStatus.OK);
    }

    @ApiOperation(tags = TAG_ADMIN, value = "Get completed info of employee")
    @RequestMapping(value = "/employee/{id}", produces = {
            MediaType.APPLICATION_JSON_VALUE}, headers = ACCEPT_APPLICATION_JSON, method = RequestMethod.GET)
    public ResponseEntity<GGResponse<EmployeeFullDetailsDto>> getEmployeeById(@PathVariable("id") Integer id) {
        return new ResponseEntity<GGResponse<EmployeeFullDetailsDto>>(new GGResponse<EmployeeFullDetailsDto>(administrationService.getEmployeeById(id), null, true), HttpStatus.OK);
    }

    @RequestMapping(value = "/employee/{id}/summary", produces = {
            MediaType.APPLICATION_JSON_VALUE}, headers = ACCEPT_APPLICATION_JSON, method = RequestMethod.GET)
    public ResponseEntity<GGResponse<EmployeeDto>> getEmployeeSummaryById(@PathVariable("id") Integer id) {
        return new ResponseEntity<GGResponse<EmployeeDto>>(new GGResponse<EmployeeDto>(administrationService.getEmployeeSummaryById(id), null, true), HttpStatus.OK);
    }

    @ApiOperation(tags = TAG_ADMIN, value = "Get all the employes")
    @RequestMapping(value = "/employee", produces = {
            MediaType.APPLICATION_JSON_VALUE}, headers = ACCEPT_APPLICATION_JSON, method = RequestMethod.GET)
    public ResponseEntity<GGResponse<List<EmployeeDto>>> geAllEmployee() {
        return new ResponseEntity<GGResponse<List<EmployeeDto>>>(new GGResponse<List<EmployeeDto>>(administrationService.getAllEmployee(), null, true),
                HttpStatus.OK);
    }

    @ApiOperation(tags = TAG_ADMIN, value = "Create Employee")
    @RequestMapping(value = "/employee", produces = {
            MediaType.APPLICATION_JSON_VALUE}, headers = ACCEPT_APPLICATION_JSON, method = RequestMethod.POST)
    public ResponseEntity<GGResponse<EmployeeFullDetailsDto>> createEmployee(@RequestBody EmployeeRequest employeeRequest) {
        return new ResponseEntity<GGResponse<EmployeeFullDetailsDto>>(new GGResponse<EmployeeFullDetailsDto>(administrationService.createEmployee(employeeRequest), null, true),
                HttpStatus.OK);
    }

    @ApiOperation(tags = TAG_ADMIN, value = "Update Employee")
    @RequestMapping(value = "/employee", produces = {
            MediaType.APPLICATION_JSON_VALUE}, headers = ACCEPT_APPLICATION_JSON, method = RequestMethod.PUT)
    public ResponseEntity<GGResponse<EmployeeFullDetailsDto>> updateEmployee(@RequestBody EmployeeRequest employeeRequest) {
        return new ResponseEntity<GGResponse<EmployeeFullDetailsDto>>(new GGResponse<EmployeeFullDetailsDto>(administrationService.updateEmployee(employeeRequest), null, true),
                HttpStatus.OK);
    }

    @ApiOperation(tags = TAG_ADMIN, value = "Get employees by filter")
    @RequestMapping(value = "/employee/filterBy/{EmployeeFilterList}", produces = {
            MediaType.APPLICATION_JSON_VALUE}, headers = ACCEPT_APPLICATION_JSON, method = RequestMethod.GET)
    public ResponseEntity<GGResponse<List<EmployeeDto>>> getEmployeeByFilter(@PathVariable("EmployeeFilterList") EmployeeFilterListType employeeFilterList) {
        return new ResponseEntity<GGResponse<List<EmployeeDto>>>(new GGResponse<List<EmployeeDto>>(administrationService.getEmployeeByFilter(employeeFilterList), null,
                true), HttpStatus.OK);
    }

    @ApiOperation(tags = TAG_ADMIN, value = "Get all employee from a office")
    @RequestMapping(value = "/office/{id}/employee", produces = {
            MediaType.APPLICATION_JSON_VALUE}, headers = ACCEPT_APPLICATION_JSON, method = RequestMethod.GET)
    public ResponseEntity<GGResponse<List<EmployeeDto>>> getEmployeeSummaryByOfficeId(@PathVariable("id") Integer id) {
        return new ResponseEntity<GGResponse<List<EmployeeDto>>>(new GGResponse<List<EmployeeDto>>(administrationService.getEmployeeSummaryByOfficeId(id), null, true),
                HttpStatus.OK);
    }

    @ApiOperation(tags = TAG_ADMIN, value = "login method")
    @RequestMapping(value = "/login", produces = {
            MediaType.APPLICATION_JSON_VALUE}, headers = ACCEPT_APPLICATION_JSON, method = RequestMethod.POST)
    public ResponseEntity<GGResponse<EmployeeFullDetailsDto>> login(@RequestBody LoginRequest loginRequest) {
        return new ResponseEntity<GGResponse<EmployeeFullDetailsDto>>(administrationService.login(loginRequest.getEmail(), loginRequest.getPassword()), HttpStatus.OK);
    }

    // @RequestMapping(value = "/encrypt", produces = {
    // MediaType.APPLICATION_JSON_VALUE}, headers = ACCEPT_APPLICATION_JSON, method = RequestMethod.POST)
    // public ResponseEntity<GGResponse<Boolean>> encrypt() {
    // return new ResponseEntity<GGResponse<Boolean>>(new GGResponse<Boolean>(administrationService.encrypt(true), null, true), HttpStatus.OK);
    // }
    //
    // @RequestMapping(value = "/decrypt", produces = {
    // MediaType.APPLICATION_JSON_VALUE}, headers = ACCEPT_APPLICATION_JSON, method = RequestMethod.POST)
    // public ResponseEntity<GGResponse<Boolean>> decrypt() {
    // return new ResponseEntity<GGResponse<Boolean>>(new GGResponse<Boolean>(administrationService.encrypt(false), null, true), HttpStatus.OK);
    // }

    @ApiOperation(tags = TAG_ADMIN, value = "Get all the AppraisalType and Criteria Name to evaluate")
    @RequestMapping(value = "/appraisalType", produces = {
            MediaType.APPLICATION_JSON_VALUE}, headers = ACCEPT_APPLICATION_JSON, method = RequestMethod.GET)
    public ResponseEntity<GGResponse<List<AppraisalTypeDto>>> geAllAppraisalType() {
        return new ResponseEntity<GGResponse<List<AppraisalTypeDto>>>(new GGResponse<List<AppraisalTypeDto>>(administrationService.getAllAppraisalType(), null, true),
                HttpStatus.OK);
    }
}
