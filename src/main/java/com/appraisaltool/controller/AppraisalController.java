package com.appraisaltool.controller;

import static com.appraisaltool.commons.Constants.ACCEPT_APPLICATION_JSON;
import static com.appraisaltool.commons.Constants.MAPPING_APPRAISAL_TOOL;
import static com.appraisaltool.commons.Constants.TAG_APPRAISAL;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.appraisaltool.model.Appraisal;
import com.appraisaltool.response.GGResponse;
import com.appraisaltool.service.AppraisalService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = {
        "http://localhost:4200", "http://localhost:4201"}, maxAge = 3600)
@RestController
@RequestMapping(value = MAPPING_APPRAISAL_TOOL + "/" + TAG_APPRAISAL)
@Api(value = "Appraisal functions", tags = TAG_APPRAISAL)
public class AppraisalController {

    @Autowired
    private AppraisalService appraisalService;

    @ApiOperation(tags = TAG_APPRAISAL, value = "Create an appraisal assignment to an specific employee")
    @RequestMapping(value = "/employee/{employeeId}", produces = {
            MediaType.APPLICATION_JSON_VALUE}, headers = ACCEPT_APPLICATION_JSON, method = RequestMethod.POST)
    public ResponseEntity<GGResponse<List<Appraisal>>> createAppraisalToEmployee(@PathVariable Integer employeeId) {
        return new ResponseEntity<GGResponse<List<Appraisal>>>(new GGResponse<List<Appraisal>>(appraisalService.assignAppraiserToEmployee(employeeId), null, true), HttpStatus.OK);
    }

    @ApiOperation(tags = TAG_APPRAISAL, value = "Get specific apraisal")
    @RequestMapping(value = "/{appraisalId}", produces = {
            MediaType.APPLICATION_JSON_VALUE}, headers = ACCEPT_APPLICATION_JSON, method = RequestMethod.GET)
    public ResponseEntity<GGResponse<Appraisal>> getAppraisal(@PathVariable Integer appraisalId) {
        return new ResponseEntity<GGResponse<Appraisal>>(new GGResponse<Appraisal>(appraisalService.getAppraisalById(appraisalId), null, true), HttpStatus.OK);
    }
}
