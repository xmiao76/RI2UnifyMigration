package com.ri2unify.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ri2unify.extract.RIParser;
import com.ri2unify.rimodel.RIReport;
import com.ri2unify.transform.RI2UnifyTransformer;
import com.ri2unify.unifymodel.UnifyReport;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Component
@RestController
public class RI2UnifyController {

    @ApiOperation(value = "Transform RI report to Unify report")
    @GetMapping(value = "/transform")
    public String transformRI2Unify(@RequestParam(value = "riReportPath",required = true) String path){
        RIReport riReport = RIParser.parseRIReport(path);
        UnifyReport unifyReport = RI2UnifyTransformer.sheet2report(riReport,1);
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.writeValueAsString(unifyReport);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return e.getMessage();
        }
    }

}
