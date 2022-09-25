package com.bjpowernode.config;

import com.bjpowernode.web.MyServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebApplicationConfig {

    @Bean
    public ServletRegistrationBean servletRegistrationBean(){

        /*ServletRegistrationBean bean =
                new ServletRegistrationBean(new MyServlet(),"/my");*/

        ServletRegistrationBean bean = new ServletRegistrationBean();
        bean.setServlet(new MyServlet());
        bean.addUrlMappings("/login","/test");

        return bean;
    }
}
