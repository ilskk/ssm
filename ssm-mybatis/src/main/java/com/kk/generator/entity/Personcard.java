package com.kk.generator.entity;

public class Personcard {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column personcard.cid
     *
     * @mbg.generated
     */
    private Integer cid;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column personcard.cinfo
     *
     * @mbg.generated
     */
    private String cinfo;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column personcard.cid
     *
     * @return the value of personcard.cid
     *
     * @mbg.generated
     */
    public Integer getCid() {
        return cid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column personcard.cid
     *
     * @param cid the value for personcard.cid
     *
     * @mbg.generated
     */
    public void setCid(Integer cid) {
        this.cid = cid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column personcard.cinfo
     *
     * @return the value of personcard.cinfo
     *
     * @mbg.generated
     */
    public String getCinfo() {
        return cinfo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column personcard.cinfo
     *
     * @param cinfo the value for personcard.cinfo
     *
     * @mbg.generated
     */
    public void setCinfo(String cinfo) {
        this.cinfo = cinfo == null ? null : cinfo.trim();
    }
}