package com.estsoft.spring_project.crud.filter;
import jakarta.servlet.*;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

@Slf4j
public class SecondFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("SecondFilter init()");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        String queryString = request.getQueryString();

        log.info("SecondFilter - queryString = {}" + queryString);

        filterChain.doFilter(request, servletResponse);

        log.info("SecondFilter response");
    }

    @Override
    public void destroy() {
        log.info("SecondFilter destroy()");
    }
}
