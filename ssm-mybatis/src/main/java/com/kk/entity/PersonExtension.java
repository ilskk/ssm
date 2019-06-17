package com.kk.entity;

public class PersonExtension extends Person {
    private Integer cid;
    private String cinfo;

    @Override
    public String toString() {
        return super.toString()+"\r\nPersonExtension{" +
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
