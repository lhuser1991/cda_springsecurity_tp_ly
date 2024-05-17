package com.cda.springsecurity.tp_back.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/springsecuritytp/admin")
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
public class AdminController {
    
    @GetMapping("/hello")
    public String helloAdmin() {
        return "Hello Admin !";
    }

    @GetMapping("/goodbye")
    public String goodbyeAdmin() {
        return "Goodbye Admin !";
    }
}
