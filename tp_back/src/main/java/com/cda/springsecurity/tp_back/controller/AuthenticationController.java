package com.cda.springsecurity.tp_back.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cda.springsecurity.tp_back.model.Connexion;
import com.cda.springsecurity.tp_back.model.Inscription;
import com.cda.springsecurity.tp_back.model.JsonWebToken;
import com.cda.springsecurity.tp_back.model.User;
import com.cda.springsecurity.tp_back.service.ConnexionService;
import com.cda.springsecurity.tp_back.service.InscriptionService;

@RestController
@RequestMapping("/springsecuritytp/authentication")
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
public class AuthenticationController {

    @Autowired
    private InscriptionService inscriptionService;

    @Autowired
    private ConnexionService connexionService;

    @GetMapping("/hello")
    public String helloAuthentication() {
        return "Hello Authentication !";
    }

    @PostMapping("/inscription")
    public ResponseEntity<User> inscription(@RequestBody Inscription inscription) {
        return ResponseEntity.ok(inscriptionService.inscription(inscription));
    }

    @PostMapping("/connexion")
    public ResponseEntity<JsonWebToken> connexion(@RequestBody Connexion connexion) {
        return ResponseEntity.ok(connexionService.connexion(connexion));
    }
    
}
