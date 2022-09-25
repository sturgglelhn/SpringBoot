package com.bjpowernode.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class HellThymeleafController {

    @GetMapping("/hello")
    public String helloThymeleaf(Model model,HttpServletRequest request){
        //添加数据到request作用域，模版引擎可以从request中获取数据
        request.setAttribute("data","欢迎使用thymeleaf模版引擎");

        //使用model存放对象
        model.addAttribute("mydata","model中的数据");


        //指定视图（模版引用使用的页面（heml））
        //逻辑名称
        return "hello";
    }
}
