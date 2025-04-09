package com.estsoft.spring_project.crud.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@Controller
public class PageController {
    @GetMapping("/thymeleaf/example")
    public String thymeleafPage(Model model) {
        Person person = new Person();
        person.setId(1L);
        person.setName("노영재");
        person.setAge(26);
        person.setHobbies(List.of("운동", "노래"));

        model.addAttribute("person", person);
        model.addAttribute("today", LocalDateTime.now());

        return "examplePage";
    }
}
