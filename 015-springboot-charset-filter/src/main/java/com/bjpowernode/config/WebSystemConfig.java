package com.bjpowernode.config;

import com.bjpowernode.web.MyServlet;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.CharacterEncodingFilter;

import javax.servlet.ServletRegistration;


@Configuration
public class WebSystemConfig {

    //注册Servlet
    @Bean
    public ServletRegistrationBean servletRegistrationBean(){
        MyServlet myServlet = new MyServlet();
        ServletRegistrationBean reg =
                new ServletRegistrationBean(myServlet,"/myServlet");

        return reg;
    }

    // 注册filter
    @Bean
    public FilterRegistrationBean filterRegistrationBean(){
        FilterRegistrationBean reg = new FilterRegistrationBean();
        //使用框架中的过滤器
        CharacterEncodingFilter filter = new CharacterEncodingFilter();
        // 指定使用的编码方式
        filter.setEncoding("utf-8");
        //指定request，response都使用encoding的值
        filter.setForceEncoding(true);

        reg.setFilter(filter);

        // 指定过滤的utl地址
        reg.addUrlPatterns("/*");

        return reg;
    }


}
