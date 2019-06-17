package com.kk.service;

public class AdviceService {

    private String string;

    public void service(){
        System.out.println("服务……");
    }

    public String demo(String str)throws  ArithmeticException{
//        int x=1/0;
//        string.toString();
        System.out.println("演示...");
        return str;
    }

}
