package com.bjpowernode.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class JspController {

    /*public String doJsp(HttpServletRequest request){

        request.setAttribute("data","SpringBoot使用JSP");
        //视图的逻辑名称
        return "index";
    }*/

    @RequestMapping("/myjsp")
    public String doJsp(Model model){

        model.addAttribute("data","SpringBoot使用JSP");
        //视图的逻辑名称
        return "index";
    }
}
