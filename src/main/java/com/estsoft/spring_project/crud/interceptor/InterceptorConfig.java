package com.estsoft.spring_project.crud.interceptor;

import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class InterceptorConfig  implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new FirstInterceptor())
                .order(1)
                .addPathPatterns("/test");

        registry.addInterceptor(new SecondInterceptor())
                .order(2)
                .addPathPatterns("/test");
    }
}
