package com.ri2unify.rimodel;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Member {
    public String name;
    public String caption;
    public String allMember;
    public List<Levels> levels;

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Levels{
        public String name;
        public String caption;
    }
}
