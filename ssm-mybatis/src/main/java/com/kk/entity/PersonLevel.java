package com.kk.entity;

import java.util.List;

public class PersonLevel {
    private Integer lid;
    private String lname;
    private List<Person> list;

    @Override
    public String toString() {
        return "PersonLevel{" +
                "lid=" + lid +
                ", lname='" + lname + '\'' +
                ", list=" + list +
                '}';
    }

    public List<Person> getList() {
        return list;
    }

    public void setList(List<Person> list) {
        this.list = list;
    }

    public Integer getLid() {
        return lid;
    }

    public void setLid(Integer lid) {
        this.lid = lid;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }
}
