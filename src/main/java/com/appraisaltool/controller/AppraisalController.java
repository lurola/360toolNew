package com.appraisaltool.controller;

import static com.appraisaltool.commons.Constants.ACCEPT_APPLICATION_JSON;
import static com.appraisaltool.commons.Constants.MAPPING_APPRAISAL_TOOL;
import static com.appraisaltool.commons.Constants.TAG_APPRAISAL;
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
import com.appraisaltool.dto.AppraisalDto;
import com.appraisaltool.dto.AppraisalItemDto;
import com.appraisaltool.dto.AppraisalsByCriteriaNameDto;
import com.appraisaltool.response.GGResponse;
import com.appraisaltool.service.AppraisalService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = {
        "http://localhost:4200", "http://localhost:4201"}, maxAge = 3600)
@RestController
@RequestMapping(value = MAPPING_APPRAISAL_TOOL + "/" + TAG_APPRAISAL)
@Api(value = "Appraisal functions", tags = TAG_APPRAISAL, description = "Appraisal functions")
public class AppraisalController {

    @Autowired
    private AppraisalService appraisalService;

    @ApiOperation(tags = TAG_APPRAISAL, value = "Get specific apraisal")
    @RequestMapping(value = "/{appraisalId}", produces = {
            MediaType.APPLICATION_JSON_VALUE}, headers = ACCEPT_APPLICATION_JSON, method = RequestMethod.GET)
    public ResponseEntity<GGResponse<AppraisalDto>> getAppraisal(@PathVariable Integer appraisalId) {
        return new ResponseEntity<GGResponse<AppraisalDto>>(new GGResponse<AppraisalDto>(appraisalService.getAppraisalById(appraisalId), null, true), HttpStatus.OK);
    }

    @ApiOperation(tags = TAG_APPRAISAL, value = "Update apraisal value")
    @RequestMapping( produces = {
            MediaType.APPLICATION_JSON_VALUE}, headers = ACCEPT_APPLICATION_JSON, method = RequestMethod.PUT)
    public ResponseEntity<GGResponse<String>> updateAppraisalValues(@RequestBody AppraisalDto appraisalDto) {
        return new ResponseEntity<GGResponse<String>>(new GGResponse<String>(appraisalService.updateAppraisalValues(appraisalDto), null, true), HttpStatus.OK);
    }

    @ApiOperation(tags = TAG_APPRAISAL, value = "Update apraisal item value")
    @RequestMapping(value = "/item", produces = {
            MediaType.APPLICATION_JSON_VALUE}, headers = ACCEPT_APPLICATION_JSON, method = RequestMethod.PUT)
    public ResponseEntity<GGResponse<String>> updateAppraisalItemValues(@RequestBody AppraisalItemDto appraisalItemDto) {
        return new ResponseEntity<GGResponse<String>>(new GGResponse<String>(appraisalService.updateAppraisalItemValue(appraisalItemDto), null, true), HttpStatus.OK);
    }

    @ApiOperation(tags = TAG_APPRAISAL, value = "delete specific apraisal")
    @RequestMapping(value = "/{appraisalId}", produces = {            MediaType.APPLICATION_JSON_VALUE}, headers = ACCEPT_APPLICATION_JSON, method = RequestMethod.DELETE)
    public ResponseEntity<GGResponse<String>> deleteAppraisal(@PathVariable Integer appraisalId) {
        appraisalService.deleteAppraisal(appraisalId);

        return new ResponseEntity<GGResponse<String>>(new GGResponse<String>("Delete sucessful", null, true), HttpStatus.OK);
    }

    @ApiOperation(tags = TAG_APPRAISAL, value = "Get AppraisalItem by criteriaName")
    @RequestMapping(value = "/{evalDate}/{appraiserId}/{appraisalTypeId}/{criteriaNameId}", produces = {
            MediaType.APPLICATION_JSON_VALUE}, headers = ACCEPT_APPLICATION_JSON, method = RequestMethod.GET)
    public ResponseEntity<GGResponse<AppraisalsByCriteriaNameDto>> getAppraisalItemByCriteriaName(@PathVariable Integer evalDate, @PathVariable Integer appraiserId,
            @PathVariable Integer appraisalTypeId, @PathVariable Integer criteriaNameId) {
        return new ResponseEntity<GGResponse<AppraisalsByCriteriaNameDto>>(new GGResponse<AppraisalsByCriteriaNameDto>(appraisalService.getAppraisalByCriteria(evalDate,
                appraiserId, appraisalTypeId, criteriaNameId), null, true), HttpStatus.OK);
    }


}
