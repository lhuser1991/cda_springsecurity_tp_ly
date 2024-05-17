package com.cda.springsecurity.tp_back.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/springsecuritytp/common")
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
public class CommonController {

    @GetMapping("/hello")
    public String helloCommon() {
        return "Hello Common !";
    }
}
