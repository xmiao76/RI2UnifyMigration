package com.ri2unify.extract;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ri2unify.rimodel.RIReport;

import java.io.File;
import java.io.IOException;

public class RIParser {
    public static String parseJson(String path) {
        ObjectMapper mapper = new ObjectMapper();
        //JSON file to Java object
        try {
            RIReport obj = mapper.readValue(new File(path), RIReport.class);
            // Java object to JSON string
            return mapper.writeValueAsString(obj);
        } catch (IOException e) {
            e.printStackTrace();
            return e.getMessage();
        }
    }

    public static RIReport parseRIReport(String path) {
        ObjectMapper mapper = new ObjectMapper();
        //JSON file to Java object
        try {
            File file = new File(path);
            RIReport riReport = mapper.readValue(new File(path), RIReport.class);
            riReport.parseReportName(file.getName());
            return riReport;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


}
