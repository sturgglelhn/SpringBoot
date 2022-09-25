package com.bjpowernode.web;

import javax.servlet.*;
import java.io.IOException;

public class MyFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("执行MyFilter，doFilter");
        filterChain.doFilter(servletRequest,servletResponse);
    }
}
