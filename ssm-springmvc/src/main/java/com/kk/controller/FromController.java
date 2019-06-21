package com.kk.controller;

import com.kk.enriry.People;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class FromController {

    @RequestMapping("/fc")
    public String form(Map<String, Object> map){
        People people =new People();
//        people.setId(5);
//        people.setName("w");
//        people.setSex(false);

        List<String> list=new ArrayList<>();
        list.add("A");
        list.add("B");
        people.setList(list);

//        Address address=new Address();
//        people.setAddress(address);

        //全部的选项
//        List<String> all=new ArrayList<>();
//        all.add("A");
//        all.add("B");
//        all.add("C");
//        all.add("O");

//        Map<String,String> hs=new HashMap<>();
//        hs.put("A","啊");
//        hs.put("O","吧");
//        hs.put("C","呲");
//        hs.put("B","哦");
//
//        map.put("all",hs);


        Map<String,String> allColor=new HashMap<>();
        allColor.put("A","啊");
        allColor.put("O","哦");
        allColor.put("C","呲");
        allColor.put("B","吧");

        map.put("cs",allColor);
        people.setString("O");

        map.put("peo",people);
        people.setCountry("China");

        return "form";
    }

    @RequestMapping(value = "/test",method = RequestMethod.POST)
    public String post(){
        System.out.println("post...");
        return "form";
    }

    @RequestMapping(value = "/test",method = RequestMethod.DELETE)
    public String delete(){
        System.out.println("delete...");
        return "form";
    }

    @RequestMapping(value = "/test",method = RequestMethod.PUT)
    public String put(){
        System.out.println("put...");
        return "form";
    }

    @RequestMapping(value = "/test",method = RequestMethod.GET)
    public String get(){
        System.out.println("get...");
        return "form";
    }

}
