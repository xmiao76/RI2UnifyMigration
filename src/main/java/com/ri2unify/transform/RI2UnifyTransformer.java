package com.ri2unify.transform;

import com.ri2unify.rimodel.InnerComponent;
import com.ri2unify.rimodel.Member;
import com.ri2unify.rimodel.RIReport;
import com.ri2unify.unifymodel.UnifyReport;

import java.util.ArrayList;
import java.util.List;

public class RI2UnifyTransformer {
    public static List<UnifyReport> report2reports(RIReport riReport){
        List<UnifyReport> unifyReports = new ArrayList<UnifyReport>();
        int sheetNum = 0;
        for(RIReport.Sheets sheet :riReport.sheets) {
            UnifyReport unifyReport = sheet2report(riReport,++sheetNum);
            unifyReports.add(unifyReport);
        }
        return unifyReports;
    }

    //select one of the RI sheet components to transform to an Unify report //TODO
    public static UnifyReport sheet2report(RIReport riReport, int sheetNum){
        UnifyReport unifyReport =  new UnifyReport();
        RIReport.Sheets sheet = riReport.sheets.get(sheetNum-1);
        unifyReport.reportName = riReport.name+"_"+sheet.name;
        unifyReport.workspaceId = "26d985167101e3e8:5d2ba75:1797b167085:-2d77";//TODO
        unifyReport.modelId = "39306";//TODO
        List<InnerComponent> components = new ArrayList<InnerComponent>();
        for (RIReport.Sheets.Rows row:sheet.rows){
            for(RIReport.Sheets.Rows.Columns column:row.columns) {
                components.add(column.innerComponent);
            }
        }
        //for now select first component of the sheet //TODO
        InnerComponent component = components.get(0);
        return component2report(unifyReport,component);
    }

    public static UnifyReport component2report(UnifyReport unifyReport, InnerComponent component){
        unifyReport.gridLayout.row = rows2Rows(component.rows);
        //RI styple report measures always in column
        List<Member> colMeasures = component.measures;//TODO merge columns and measures
        unifyReport.gridLayout.column = cols2Cols(colMeasures);
        return unifyReport;
    }

    public static List<UnifyReport.GridLayout.Row> rows2Rows(List<Member> rows){
        List<UnifyReport.GridLayout.Row> unifyRows = new ArrayList<UnifyReport.GridLayout.Row>();
        for (Member row:rows){
            UnifyReport.GridLayout.Row unifyRow = row2Row(row);
            unifyRows.add(unifyRow);
        }
        return unifyRows;
    }

    //RI: can have multiple dim on row, 1 dim on row can have multiple levels
    //Unify: can have multiple dim on row, 1 dim on row ca have multiple levels
    public static UnifyReport.GridLayout.Row row2Row(Member row){
        UnifyReport.GridLayout.Row unifyRow = new UnifyReport.GridLayout.Row();
        unifyRow.name = metadataMapper.unifyRowColName(row.name,"scorecard");
        //specific for scorecard test //TODO
        unifyRow.userAlias = unifyRow.name;
        unifyRow.systemAlias = unifyRow.name;
        unifyRow.members = memberLevels2Levels(row.levels);
        return unifyRow;
    }

    public static List<UnifyReport.GridLayout.Column> cols2Cols(List<Member> cols){
        List<UnifyReport.GridLayout.Column> unifyCols = new ArrayList<UnifyReport.GridLayout.Column>();
        for (Member col:cols){
            UnifyReport.GridLayout.Column unifyCol = col2Col(col);
            unifyCols.add(unifyCol);
        }
        return unifyCols;
    }

    public static UnifyReport.GridLayout.Column col2Col(Member column){
        UnifyReport.GridLayout.Column unifyColumn = new UnifyReport.GridLayout.Column();
        unifyColumn.name = metadataMapper.unifyRowColName(column.name,"scorecard");
        //specific for scorecard test //TODO
        unifyColumn.userAlias = unifyColumn.name;
        unifyColumn.systemAlias = unifyColumn.name;
        unifyColumn.members = memberLevels2Levels(column.levels);
        return unifyColumn;
    }

    public static List<com.ri2unify.unifymodel.Member> memberLevels2Levels(List<Member.Levels> levels){
        List<com.ri2unify.unifymodel.Member> unifyLevels = new ArrayList<com.ri2unify.unifymodel.Member>();
        for (Member.Levels level:levels){
            com.ri2unify.unifymodel.Member unifyLevel = memberLevel2Level(level);
            unifyLevels.add(unifyLevel);
        }
        return unifyLevels;
    }

    public static com.ri2unify.unifymodel.Member memberLevel2Level(Member.Levels level){
        com.ri2unify.unifymodel.Member unifyLevel = new com.ri2unify.unifymodel.Member();
        unifyLevel.level = metadataMapper.unifyMemberLevelName(level.name,"scorecard");
        unifyLevel.fullPath = metadataMapper.unifyMemberFullPathName(level.name,"scorecard");
        unifyLevel.name = metadataMapper.unifyMemberName(level.name,"scorecard");
        unifyLevel.functionName = metadataMapper.unifyMemberFunctionName(level.name,"scorecard");
        //specific for scorecard test //TODO
        return unifyLevel;
    }

}
