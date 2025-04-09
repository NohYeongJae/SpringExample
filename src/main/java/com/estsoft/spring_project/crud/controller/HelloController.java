package com.estsoft.spring_project.crud.controller;

import com.estsoft.spring_project.crud.service.HelloService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HelloController {

    private final HelloService helloService;

    public HelloController(HelloService helloService){
        this.helloService = helloService;
    }

    @GetMapping("/hello")
    public String hello() {
        return helloService.sayHello();
    }
}

