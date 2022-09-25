package com.bjpowernode.service.impl;

import com.bjpowernode.model.Student;
import com.bjpowernode.service.StudentService;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.stereotype.Component;


/**
 * 使用dubbo中的注解暴露服务
 */
@Component
@DubboService(interfaceClass = StudentService.class,version = "1.0")
public class StudentServiceImpl implements StudentService {

    @Override
    public Student queryStudent(Integer id) {

        Student student = new Student();
        if(1001 == id){
            student.setId(1001);
            student.setName("lisi");
            student.setAge(20);
        }else if(1002 == id){
            student.setId(1002);
            student.setName("zhangsan");
            student.setAge(25);
        }

        return student;
    }
}
