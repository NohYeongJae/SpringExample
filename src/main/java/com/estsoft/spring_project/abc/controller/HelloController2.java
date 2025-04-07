package com.estsoft.spring_project.abc.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController2 {

    @GetMapping("/hello2")
    public String newPage() {
        return "hi";
    }
}
