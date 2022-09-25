package com.bjpowernode.controller;


import com.bjpowernode.vo.SchoolInfo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
public class HelloController {
    @Value("${server.port}")
    private String port;
    @Value("${school.name}")
    private String name;
    @Value("${site}")
    private String site;

    @RequestMapping("/hello")
    @ResponseBody
    public String doHello(){
        return "hello,port:"+port+",学校:"+name+",网站:"+site;
    }

    @Resource
    private SchoolInfo schoolInfo;

    @RequestMapping("/myschool")
    @ResponseBody
    public String doSchool(){
        return "学校信息：" + schoolInfo.toString();
    }

}
