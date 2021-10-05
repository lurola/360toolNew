package com.appraisaltool.controller;

import static com.appraisaltool.commons.Constants.ACCEPT_APPLICATION_JSON;
import static com.appraisaltool.commons.Constants.MAPPING_APPRAISAL_TOOL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.appraisaltool.dto.domain.LookupType;
import com.appraisaltool.response.GGResponse;
import com.appraisaltool.response.LookupDataResults;
import com.appraisaltool.service.AdministrationService;

@RestController
@RequestMapping(value = MAPPING_APPRAISAL_TOOL + "/admin")
public class AdministrationController {

    @Autowired
    private AdministrationService administrationService;

    @RequestMapping(value = "/lookup/{lookupType}", produces = {
            MediaType.APPLICATION_JSON_VALUE}, headers = ACCEPT_APPLICATION_JSON, method = RequestMethod.GET)
    public ResponseEntity<GGResponse<LookupDataResults>> getLookup(@PathVariable("lookupType") LookupType lookupType) {
        LookupDataResults lookupDataResults = administrationService.getLookupDataResult(lookupType);

        return new ResponseEntity<GGResponse<LookupDataResults>>( new GGResponse<LookupDataResults>(lookupDataResults, null, true), HttpStatus.OK);
    }

    @RequestMapping(value = "/lookup/{lookupType}/{id}", produces = {
            MediaType.APPLICATION_JSON_VALUE}, headers = ACCEPT_APPLICATION_JSON, method = RequestMethod.GET)
    public ResponseEntity<GGResponse<LookupDataResults>> getLookupById(@PathVariable("lookupType") LookupType lookupType, @PathVariable("id") Integer id) {
        LookupDataResults lookupDataResults = administrationService.getLookupDataResult(lookupType, id);

        return new ResponseEntity<GGResponse<LookupDataResults>>(new GGResponse<LookupDataResults>(lookupDataResults, null, true), HttpStatus.OK);
    }
}
