package com.bjpowernode.controller;

import com.bjpowernode.model.Cat;
import com.bjpowernode.model.Dog;
import com.bjpowernode.model.SysUser;
import com.bjpowernode.model.Zoo;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.jws.WebParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.*;

@Controller
@RequestMapping("/tpl")
public class thymeleafController {

    // 第一个标准变量表达式
    @GetMapping("/expression1")
    public String expression1(Model model){
        // 添加数据到Model
        model.addAttribute("site","www.bjpowernode.com");
        model.addAttribute("myuser",new SysUser(1001,"李四","男",20));

        // 指定视图
        return "expression1";
    }

    // 选择变量表达式
    @GetMapping("/expression2")
    public String expression2(Model model){
        // 添加数据到Model
        model.addAttribute("site","www.bjpowernode.com");
        model.addAttribute("myuser",new SysUser(1001,"李四","男",20));

        // 指定视图
        return "expression2";
    }

    //链接表达式
    @GetMapping("/link")
    public String link(Model model){
        model.addAttribute("userId",1002);
        return "link";
    }

    @GetMapping("/queryAccount")
    @ResponseBody
    public String queryAccount(Integer id){

        return "queryAccount，参数id="+id;
    }


    //有两个参数的地址
    @GetMapping("/queryUser")
    @ResponseBody
    public String queryUser(String name,Integer age){

        return "姓名："+name+",年龄："+age;
    }


    //模版的属性
    @GetMapping("/property")
    public String property(Model model){
        model.addAttribute("mythodAttr","post");
        model.addAttribute("id","2342");

        model.addAttribute("paramname","name");
        model.addAttribute("uservalue","lisi");

        return "html-property";
    }

    //循环LIst
    @GetMapping("/eachList")
    public String eachList(Model model){
        List<SysUser> users = new ArrayList<>();
        users.add(new SysUser(1001,"张三","男",20));
        users.add(new SysUser(1002,"关羽","男",25));
        users.add(new SysUser(1003,"张飞","男",66));
        users.add(new SysUser(1004,"刘备","男",70));
        users.add(new SysUser(1005,"孙尚香","女",22));

        model.addAttribute("myuser",users);
        return "eachList";
    }

    //循环数组
    @GetMapping("/eachArray")
    public String eachArray(Model model){
        SysUser[] users = new SysUser[3];
        users[0] = new SysUser(1001,"马超","男",22);
        users[1] = new SysUser(1002,"黄忠","男",26);
        users[2] = new SysUser(1003,"赵云","男",29);
        model.addAttribute("userarray",users);
        return "eacharray";
    }

    @GetMapping("/eachMap")
    public String eachMap(Model model){

        //循环Map
        HashMap<String, SysUser> map = new HashMap<>();
        map.put("user1",new SysUser(11001,"马超","男",22));
        map.put("user2",new SysUser(11002,"曹操","男",55));
        map.put("user3",new SysUser(11003,"孙权","男",43));
        model.addAttribute("usermap",map);

        //List<Map<SysUser>>

        List<Map<String,SysUser>> listmap = new ArrayList<>();
        listmap.add(map);

        map = new HashMap<>();
        map.put("sys1",new SysUser(2001,"曹操","男",22));
        map.put("sys2",new SysUser(2002,"刘备","男",29));
        map.put("sys3",new SysUser(2003,"司马懿","男",21));

        listmap.add(map);

        model.addAttribute("listmap",listmap);

        return "eachmap";
    }

    //ifunless的使用
    @GetMapping("/ifunless")
    public String ifunless(Model model){
        model.addAttribute("sex","m");
        model.addAttribute("isLogin",true);
        model.addAttribute("age",20);
        model.addAttribute("name","");
        model.addAttribute("isOld",null);

        return "ifunless";
    }

    @GetMapping("/inline")
    public String inline(Model model){
        model.addAttribute("sex","m");
        model.addAttribute("isLogin",true);
        model.addAttribute("age",20);
        model.addAttribute("name","克里斯");
        model.addAttribute("myuser",new SysUser(1005,"周向","f",23));

        return "inline";
    }

    @GetMapping("/text")
    public String text(Model model){
        model.addAttribute("sex","m");
        model.addAttribute("isLogin",true);
        model.addAttribute("age",20);
        model.addAttribute("name",null);
        model.addAttribute("city","北京");

        model.addAttribute("myuser",new SysUser(1005,"周向","f",23));

        return "text";
    }

    @GetMapping("/baseObject")
    public String baseObject(Model model, HttpServletRequest request,
                             HttpSession session){
        request.setAttribute("reqdata","request中的数据");
        request.getSession().setAttribute("sessdata","session中数据");
        session.setAttribute("loginname","zhangsan");

        return "baseObject";
    }

    @GetMapping("/utilObject")
    public String utilObject(Model model,HttpSession session){
        model.addAttribute("mydate",new Date());
        model.addAttribute("mynum",26.987);
        model.addAttribute("mystr","bjpowernode");

        List<String> mylist = Arrays.asList("a","b","c");
        model.addAttribute("mylist",mylist);

        session.setAttribute("loginname","zhangsan");

        Dog dog = new Dog();
        dog.setName("二哈");

        Cat cat = new Cat();
        cat.setName("英短");

        Zoo zoo = new Zoo();
        zoo.setCat(cat);
        /*zoo.setDog(dog);*/

        model.addAttribute("zoo",zoo);

        return "utilObject";
    }

    // 自定义模版
    @GetMapping("/customtpl")
    public String customTemplates(Model model){

        return "customtpl";
    }

}
