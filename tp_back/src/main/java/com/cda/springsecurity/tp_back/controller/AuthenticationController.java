package com.cda.springsecurity.tp_back.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/springsecuritytp/authentication")
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
public class AuthenticationController {
    
    @GetMapping("/hello")
    public String helloAuthentication() {
        return "Hello Authentication !";
    }
    
}
