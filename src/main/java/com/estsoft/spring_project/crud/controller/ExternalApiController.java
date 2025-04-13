package com.estsoft.spring_project.crud.controller;

import com.estsoft.spring_project.crud.service.ExternalService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ExternalApiController {

    private final ExternalService externalService;

    public ExternalApiController(ExternalService externalService) {
        this.externalService = externalService;
    }

    @GetMapping("/api/external")
    public ResponseEntity<String> callExternal() {
        // RestTemplate
        externalService.call();

        return ResponseEntity.ok().build();
    }

}
