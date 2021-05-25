package com.ri2unify.unifymodel;

import java.util.ArrayList;
import java.util.List;

public class Dimension {
    public String headerLevel;
    public List<Member> members = new ArrayList<Member>();
    public String dimensionName;
    public boolean singleSelect=false;
    public boolean visible = true;
    public boolean editable = true;
}
