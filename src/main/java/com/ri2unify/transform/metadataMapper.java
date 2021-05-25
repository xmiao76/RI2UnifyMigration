package com.ri2unify.transform;

import java.util.HashMap;
import java.util.Map;

public class metadataMapper {
    static Map<String, String> scRowColMap = new HashMap<>();
    static Map<String, String> scMemberLevelMap = new HashMap<>();
    static Map<String,String> scMemberFullPathMap = new HashMap<>();
    static Map<String,String> scMemberNameMap = new HashMap<>();
    static Map<String,String> scMemberFunctionNameMap = new HashMap<>();

    // metadata map harsh map , to be replaced by csv//TODO
    static {
        //row name mapping
        scRowColMap.put("PRODUCT.BRAND","Product");
        //member level mapping
        scMemberLevelMap.put("BRAND","Product");
        scMemberLevelMap.put("Recaptured Sales Amount","OSA Scorecard : FOLDER");
        scMemberLevelMap.put("Total Alerts Issued","OSA Scorecard : FOLDER");
        //member full path mapping
        scMemberFullPathMap.put("BRAND","Product.All Pepsico Products by Company");
        scMemberFullPathMap.put("Recaptured Sales Amount","Measures.All Measures : FOLDER.OSA Scorecard : FOLDER.Recaptured Sales Amount");
        scMemberFullPathMap.put("Total Alerts Issued","Measures.All Measures : FOLDER.OSA Scorecard : FOLDER.Total Alerts Issued");
        //member name mapping
        scMemberNameMap.put("BRAND","All Pepsico Products by Company");
        //member function name mapping
        scMemberFunctionNameMap.put("BRAND","descendantsAtLevel:PEP COMPANY5");
    }

    public static String unifyRowColName(String riRowColName, String cubeType){
        if ("scorecard".equalsIgnoreCase(cubeType) && scRowColMap.get(riRowColName)!=null){
            return scRowColMap.get(riRowColName);
        }else{
            return riRowColName;
        }
    }

    public static String unifyMemberLevelName(String riMemberLevelName,String cubeType){
        if ("scorecard".equalsIgnoreCase(cubeType) && scMemberLevelMap.get(riMemberLevelName)!=null){
            return scMemberLevelMap.get(riMemberLevelName);
        }else{
            return riMemberLevelName;
        }
    }

    public static String unifyMemberFullPathName(String riMemberLevelName,String cubeType){
        if ("scorecard".equalsIgnoreCase(cubeType) && scMemberFullPathMap.get(riMemberLevelName)!=null){
            return scMemberFullPathMap.get(riMemberLevelName);
        }else{
            return riMemberLevelName;
        }
    }

    public static String unifyMemberName(String riMemberLevelName,String cubeType){
        if ("scorecard".equalsIgnoreCase(cubeType) && scMemberNameMap.get(riMemberLevelName)!=null){
            return scMemberNameMap.get(riMemberLevelName);
        }else{
            return riMemberLevelName;
        }
    }

    public static String unifyMemberFunctionName(String riMemberLevelName,String cubeType){
        if ("scorecard".equalsIgnoreCase(cubeType) && scMemberFunctionNameMap.get(riMemberLevelName)!=null){
            return scMemberFunctionNameMap.get(riMemberLevelName);
        }else{
            return riMemberLevelName;
        }
    }
}
