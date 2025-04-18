package com.estsoft.spring_project.abc.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserViewController {
    // /login 연결 페이지 리턴
    @GetMapping("/login")
    public String loginView() {
        return "login";
    }

    @GetMapping("/signup")
    public String signupView() {
        return "signup";
    }
}
