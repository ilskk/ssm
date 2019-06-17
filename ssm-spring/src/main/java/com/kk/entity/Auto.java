package com.kk.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Auto {
    @Autowired
    private Teacher teacher;

    @Override
    public String toString() {
        return "Auto{" +
                "teacher=" + teacher +
                '}';
    }

    public static void main(String[] args){

    }


}
