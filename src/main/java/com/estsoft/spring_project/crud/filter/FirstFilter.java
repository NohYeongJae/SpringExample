package com.estsoft.spring_project.crud.filter;


import jakarta.servlet.*;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;

import jakarta.servlet.Filter;

import java.io.IOException;


@Slf4j
public class FirstFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("FirstFilter init");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        String requestURI = request.getRequestURI();

        log.info("FirstFilter - requestURI: {}", requestURI);

        filterChain.doFilter(request, servletResponse);
    }

    @Override
    public void destroy() {
        System.out.println("FirstFilter destroy()");
    }
}
