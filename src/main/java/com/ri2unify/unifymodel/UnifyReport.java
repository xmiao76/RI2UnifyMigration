package com.ri2unify.unifymodel;

import java.util.ArrayList;
import java.util.List;

public class UnifyReport {
    public boolean isUnifyTemplate = true;
    public String reportName;
    public String description="";
    public String workspaceId;
    public String modelId;
    public boolean asymmetric = true;
    public boolean async = true;
    public ProgressiveFilter progressiveFilter = new ProgressiveFilter();
    public Metadata metadata = new Metadata();
    public List tags = new ArrayList();
    public String businessIssues="";
    public boolean allowLayoutChange=false;
    public PaginationInfo paginationInfo = new PaginationInfo();
    public String lastAction = "pagination";
    public GridLayout gridLayout = new GridLayout();
    public boolean gridVisible = true;
    public boolean chartVisible = false;
    public List reportActions = new ArrayList();
    public AsymmetricSelection asymmetricSelection = new AsymmetricSelection();
    public VisualizerConfig visualizerConfig = new VisualizerConfig();
    public List<String> dimensionDisplayOrder = new ArrayList<String>();
    public Preferences preferences = new Preferences();

    public static class ProgressiveFilter{
        public List progressiveDimensions = new ArrayList();
    }

    public static class Metadata{
        public int margin = 0;
        public Background background = new Background();

        public static class Background{
            public String color = "";
            public String imageURL = "";
            public int opacity = 100;
        }
    }

    public static class PaginationInfo{
        public int currentRowPageNum=1;
        public int currentColPageNum=1;
    }

    public static class GridLayout{
        public List<Row> row = new ArrayList<Row>();
        public List<Column> column = new ArrayList<Column>();
        public List<Filter> filter = new ArrayList<Filter>();
        public List other = new ArrayList();

        public static class Row{
            public String name;
            public List<Member> members = new ArrayList<Member>();
            public List<Attribute> attributes = new ArrayList<Attribute>();
            public boolean isTotal = false;
            public boolean isAllOthers = false;
            public boolean isEditable = true;
            public boolean isVisible = true;
            public boolean isOptional = false;
            public String userAlias;
            public String systemAlias;
            public boolean isLocked = false;
        }

        public static class Column{
            public String name;
            public List<Member> members = new ArrayList<Member>();
            public List<Attribute> attributes = new ArrayList<Attribute>();
            public boolean isEditable = true;
            public boolean isVisible = true;
            public boolean isOptional = false;
            public String userAlias;
            public String systemAlias;
            public boolean isLocked = false;
        }

        public static class Filter{
            public String name;
            public List<Member> members = new ArrayList<Member>();
            public List<Attribute> attributes = new ArrayList<Attribute>();
            public boolean isTotal = false;
            public boolean isAllOthers = false;
            public boolean isEditable = true;
            public boolean isVisible = true;
            public boolean isOptional = false;
            public String userAlias;
            public String systemAlias;
            public boolean isLocked = false;
        }
    }

    public static class AsymmetricSelection{
        public List<Dimension> asymmetricDimension = new ArrayList<Dimension>();
        public List<Group> groups = new ArrayList<Group>();

        public static class Group {
        }
    }

    public static class VisualizerConfig {
        public GridOptions gridOptions = new GridOptions();
        public String visualizerLayout = "OneCellTemplate";
        public List<Visualizer> visualizers = new ArrayList<Visualizer>();

        public static class GridOptions{
            public boolean columnTitle = true;
            public boolean rowTitle = true;
            public boolean expandCollapse = true;
            public boolean displayBanding = false;
            public String indent = "true";
            public String rowIndent = "2";
            public String rowTitleVerticalAlign = "center";
            public String generationStyles = "none";
            public boolean missingRows = true;
            public boolean missingColumns = false;
            public boolean preserveHierarchy = true;
            public boolean zeroes = true;
            public boolean errors = true;
            public boolean showAttributesafterMeasures = false;
            public List mergedDimensionsOnColumn = new ArrayList();
            public List mergedDimensionsOnRow = new ArrayList();
            public String textExpression = "";
            public String text = "";
            public String fontColor = "#000";
            public String fontType = "proxima-nova";
            public int fontSize = 14;
            public boolean disableGridActions = false;
            public int outerBorderWidth = 0;
            public boolean headerBorder = true;
            public boolean allowIndexing = false;
            public boolean applyMemberColorToForeGround = false;
        }
    }

    public static class Preferences{
        public boolean fitToScreen = false;
    }

}
