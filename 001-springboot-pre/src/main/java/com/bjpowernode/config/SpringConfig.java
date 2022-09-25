package com.bjpowernode.config;

import com.bjpowernode.vo.Student;
import jdk.nashorn.internal.objects.annotations.Property;
import org.springframework.context.annotation.*;

import java.util.Date;


/**
 * @Configuration：表示当前类是xml配置文件的作用
 *          在这个类中有很多方法，方法的返回值是对象。
 *          在这个方法的上面加入@Bean，表示方法返回值的对象放入到容器中。
 *  @Bean ==<bean></bean>
 */
@Configuration

@ImportResource(value = "classpath:beans.xml")

@PropertySource(value = "classpath:config.properties")
@ComponentScan(value = "com.bjpowernode.vo")
public class SpringConfig {
    /**
     * 定义方法，方法的返回值是对象。
     * @Bean：表示把对象注入到容器中。
     * 位置：方法的上面
     * @Bean 没有使用属性，默认对象名称是方法名
     */
    @Bean
    public Student createStudent(){
        Student student = new Student();
        student.setId(1001);
        student.setName("陈吕琦");
        student.setAge(22);
        return student;
    }

    @Bean("myStudent2")
    public Student makeStudent(){
        Student student = new Student();
        student.setId(1002);
        student.setName("李浩南");
        student.setAge(23);
        return student;
    }

    @Bean
    public Date myDate(){
        return new Date();
    }

}
