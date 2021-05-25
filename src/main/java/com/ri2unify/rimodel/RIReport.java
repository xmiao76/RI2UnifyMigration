package com.ri2unify.rimodel;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RIReport {
    public String id;
    public List<Sheets> sheets = new ArrayList<Sheets>();
    public String name;

    public RIReport(){

    }

    //get RI report name from JSON file name, get "Alert scorecard sample 1" from "Alert scorecard sample 1.-823989976";
    public void parseReportName(String fileName){
        name = getFileBaseName(getFileBaseName(fileName));
    }

    String getFileBaseName(String filename){
        int i = filename.lastIndexOf(".");
        if (i >0)
            return filename.substring(0, i);
        else
            return filename;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Sheets{
        public List<Rows> rows = new ArrayList<Rows>();
        public String name;

        public Sheets(){

        }

        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class Rows{
            public List<Columns> columns = new ArrayList<Columns>();

            public Rows(){

            }

            @JsonIgnoreProperties(ignoreUnknown = true)
            public static class Columns{
                public InnerComponent innerComponent;

                public Columns(){

                }
            }
        }

    }

}
