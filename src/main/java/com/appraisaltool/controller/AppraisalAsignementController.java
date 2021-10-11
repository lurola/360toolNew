package com.appraisaltool.controller;

import static com.appraisaltool.commons.Constants.ACCEPT_APPLICATION_JSON;
import static com.appraisaltool.commons.Constants.MAPPING_APPRAISAL_TOOL;
import static com.appraisaltool.commons.Constants.TAG_APPRAISAL_ASIG;
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
import com.appraisaltool.dto.AppraiserAssignementDto;
import com.appraisaltool.model.Appraisal;
import com.appraisaltool.request.AppraisalRequest;
import com.appraisaltool.response.GGResponse;
import com.appraisaltool.service.AppraisalService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = {
        "http://localhost:4200", "http://localhost:4201"}, maxAge = 3600)
@RestController
@RequestMapping(value = MAPPING_APPRAISAL_TOOL + "/" + TAG_APPRAISAL_ASIG)
@Api(value = "Appraisal functions", tags = TAG_APPRAISAL_ASIG, description = "Appraisal Asgignement functions")
public class AppraisalAsignementController {

    @Autowired
    private AppraisalService appraisalService;

    @ApiOperation(tags = TAG_APPRAISAL_ASIG, value = "Create an appraisal assignment to evaluate an specific employee")
    @RequestMapping(value = "/employee/{employeeId}", produces = {
            MediaType.APPLICATION_JSON_VALUE}, headers = ACCEPT_APPLICATION_JSON, method = RequestMethod.POST)
    public ResponseEntity<GGResponse<Integer>> createAppraisalToEmployee(@PathVariable Integer employeeId, @RequestBody AppraisalRequest appraisalRequest) {
        return new ResponseEntity<GGResponse<Integer>>(new GGResponse<Integer>(appraisalService.assignAppraiserToEmployee(employeeId, appraisalRequest
                .getEvalDate()), null, true), HttpStatus.OK);
    }

    @ApiOperation(tags = TAG_APPRAISAL_ASIG, value = "Get specific apraisal")
    @RequestMapping(value = "/{appraisalId}", produces = {
            MediaType.APPLICATION_JSON_VALUE}, headers = ACCEPT_APPLICATION_JSON, method = RequestMethod.GET)
    public ResponseEntity<GGResponse<Appraisal>> getAppraisal(@PathVariable Integer appraisalId) {
        return new ResponseEntity<GGResponse<Appraisal>>(new GGResponse<Appraisal>(appraisalService.getAppraisalById(appraisalId), null, true), HttpStatus.OK);
    }

    @ApiOperation(tags = TAG_APPRAISAL_ASIG, value = "delete specific apraisal")
    @RequestMapping(value = "/{appraisalId}", produces = {
            MediaType.APPLICATION_JSON_VALUE}, headers = ACCEPT_APPLICATION_JSON, method = RequestMethod.DELETE)
    public ResponseEntity<GGResponse<String>> deleteAppraisal(@PathVariable Integer appraisalId) {
        appraisalService.deleteAppraisal(appraisalId);

        return new ResponseEntity<GGResponse<String>>(new GGResponse<String>("Delete sucessful", null, true), HttpStatus.OK);
    }

    @ApiOperation(tags = TAG_APPRAISAL_ASIG, value = "Create an appraisal assignment to evaluate to all employed from one office")
    @RequestMapping(value = "/office/{officeId}", produces = {
            MediaType.APPLICATION_JSON_VALUE}, headers = ACCEPT_APPLICATION_JSON, method = RequestMethod.POST)
    public ResponseEntity<GGResponse<Integer>> createAppraisalToEmployeeFromOffice(@PathVariable Integer officeId, @RequestBody AppraisalRequest appraisalRequest) {
        return new ResponseEntity<GGResponse<Integer>>(new GGResponse<Integer>(appraisalService.assignAppraiserToEmployeeFromOffice(officeId, appraisalRequest
                .getEvalDate()), null, true), HttpStatus.OK);
    }


    @ApiOperation(tags = TAG_APPRAISAL_ASIG,
            value = "Create a manual appraisal. The appraisalType allowed:  YOURSELF, LINE_MANAGER_2_EVALUATED, EVALUATED_2_LINE_MANAGER, TEAM_LEAD_2_EVALUATED, EVALUATED_2_TEAM_LEAD, MENTOR_2_EVALUATED, EVALUATED_2_MENTOR, TEAMMATE, GROUPMATE")
    @RequestMapping(produces = {
            MediaType.APPLICATION_JSON_VALUE}, headers = ACCEPT_APPLICATION_JSON, method = RequestMethod.POST)
    public ResponseEntity<GGResponse<Integer>> createManualAppraisal(@RequestBody AppraisalRequest appraisalRequest) {
        return new ResponseEntity<GGResponse<Integer>>(new GGResponse<Integer>(appraisalService.createAppraisal(appraisalRequest), null, true), HttpStatus.OK);
    }



    @ApiOperation(tags = TAG_APPRAISAL_ASIG, value = "Get Appraiser Assignement list")
    @RequestMapping(value = "/appriaser", produces = {
            MediaType.APPLICATION_JSON_VALUE}, headers = ACCEPT_APPLICATION_JSON, method = RequestMethod.GET)
    public ResponseEntity<GGResponse<List<AppraiserAssignementDto>>> getAppraiserAssignementList() {
        return new ResponseEntity<GGResponse<List<AppraiserAssignementDto>>>(new GGResponse<List<AppraiserAssignementDto>>(appraisalService.getAppraiserAssignement(), null, true),
                HttpStatus.OK);
    }


}
