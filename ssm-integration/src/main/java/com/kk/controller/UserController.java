package com.kk.controller;

import com.kk.entity.User;
import com.kk.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserServiceImpl service;

    @RequestMapping("/query/{id}")
    public String queryUserById(@PathVariable("id") Integer id, Model model){
       User user= service.queryUserById(id);
       model.addAttribute("user",user);
       return "index";
    }

    @RequestMapping("/queryAll")
    public String queryUserAll(Model model){
        List<User> list=service.queryUserAll();
        model.addAttribute("users",list);
        return "index";
    }

    @RequestMapping("/insert")
    public String insertUser(User user,Model model){
        int status=service.insertUser(user);
        model.addAttribute("i","注册"+status+"位");
        return "index";
    }

    @RequestMapping("/update")
    public String updateUser(User user,Model model){
        int status=service.updateUser(user);
        model.addAttribute("u","修改"+status+"位");
        return "index";
    }

    @RequestMapping("/delete/{id}")
    public String deleteUserById(@PathVariable("id") Integer id, Model model){
        int status= service.deleteUserById(id);
        model.addAttribute("d","删除"+status+"位");
        return "index";
    }

}
