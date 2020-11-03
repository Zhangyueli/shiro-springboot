package com.example.shirospringboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @program: shiroDemo1
 * @author: zhangyueli
 * @date: 2020-11-03
 */
@Controller
public class MyController {
    @RequestMapping({"/","/index"})
    public String toIndex(Model model){
        model.addAttribute("msg","hello,shiro");
        return "index";
    }

    @RequestMapping("/user/add")
    public String add(){
        return "/user/add";
    }

    @RequestMapping("/user/update")
    public String update(){
        return "/user/update";
    }

    @RequestMapping("/toLogin")
    public String login(){
        return "/login";
    }
}
