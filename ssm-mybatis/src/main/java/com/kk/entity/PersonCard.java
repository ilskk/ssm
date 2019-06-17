package com.kk.entity;

import java.io.Serializable;

public class PersonCard {

    private Integer cid;
    private String cinfo;

    public PersonCard(Integer cid, String cinfo) {
        this.cid = cid;
        this.cinfo = cinfo;
    }

    public PersonCard() {
    }

    @Override
    public String toString() {
        return "PersonCard{" +
                "cid=" + cid +
                ", cinfo='" + cinfo + '\'' +
                '}';
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getCinfo() {
        return cinfo;
    }

    public void setCinfo(String cinfo) {
        this.cinfo = cinfo;
    }
}
