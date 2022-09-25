package com.bjpowernode.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class MyRestController {

    // 学习注解的使用

    /**
     * @PathVariable(路径变量)：获取url中的数据
     *          属性：value ：路径变量名
     *          位置：放在控制器方法的形参前面
     *
     * http://localhost:8080/myboot/student/1002
     * {stuId}:定义路径变量，stuId自定义名称
     */
    // 查询id=1001的学生
    @GetMapping("/student/{stuId}")
    public String queryStudent(@PathVariable(value = "stuId") Integer studentId){
        return "查询学生studentId=" + studentId;
    }

    /**
     *  创建资源Post请求方式
     *  http://localhost:8080/myboot/student/zhangsan/20
     */
    @PostMapping("/student/{name}/{age}")
    public String createStudent(@PathVariable("name") String name,
                                @PathVariable("age") Integer age){

        return "姓名="+name+",年龄="+age;
    }


    /**
     * 更新资源：@PutMapping
     *
     * 当路径变量名称和形参名一样，@PathVariable中value可以省略
     */
    @PutMapping("/student/{id}/{age}")
    public String modifyStudent(@PathVariable Integer id,
                                @PathVariable Integer age){
        return "id="+id+",age="+age;
    }

    /**
     * 删除资源
     */
    @DeleteMapping("/student/{id}")
    public String removeStudentById(@PathVariable Integer id){
        return "删除资源：id="+id;
    }


    //@PostMapping("/student/test")
    @PutMapping("/student/test")
    public String test(){
        return "执行student/test，使用的请求方式是put";
    }

    @DeleteMapping("/student/testdelete")
    public String testdelete(){
        return "执行student/testdelete，使用的请求方式是delete";
    }
}
