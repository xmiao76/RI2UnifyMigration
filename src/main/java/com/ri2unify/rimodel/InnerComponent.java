package com.ri2unify.rimodel;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class InnerComponent{
    public String id;
    public String clientId;
    public String catalogName;
    public String cubeName;
    public String cubeCaption;
    public List<Member> filters;
    public List<Member> rows;
    public List<Member> measures;
    public InnerComponent(){
    }
}