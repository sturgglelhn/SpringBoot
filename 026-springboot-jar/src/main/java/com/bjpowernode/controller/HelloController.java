package com.bjpowernode.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {

    @RequestMapping("/hello")
    public ModelAndView deHello(){
        ModelAndView mv = new ModelAndView();
        mv.addObject("data","SpringBoot打包为jar");
        mv.setViewName("index");

        return mv;
    }
}
