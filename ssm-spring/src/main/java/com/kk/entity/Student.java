package com.kk.entity;

import com.kk.newinstance.HtmlCourse;
import com.kk.newinstance.ICourse;
import com.kk.newinstance.JavaCourse;

public class Student {
    private int stuNo;
    private String stuName;
    private int setAge;

    public void stduy(ICourse course){
        course.study();
    }

    //学习java课程
    public void studyJava(){
        ICourse course=new JavaCourse();
        course.study();
    }

    //学习html课程
    public void studyHtml(){
        ICourse course=new HtmlCourse();
        course.study();
    }

    @Override
    public String toString() {
        return "Student{" +
                "stuNo=" + stuNo +
                ", stuName='" + stuName + '\'' +
                ", setAge=" + setAge +
                '}';
    }

    public int getStuNo() {
        return stuNo;
    }

    public void setStuNo(int stuNo) {
        this.stuNo = stuNo;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public int getSetAge() {
        return setAge;
    }

    public void setSetAge(int setAge) {
        this.setAge = setAge;
    }
}
