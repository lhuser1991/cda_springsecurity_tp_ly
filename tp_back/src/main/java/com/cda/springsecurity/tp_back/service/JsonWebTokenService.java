package com.cda.springsecurity.tp_back.service;

import org.springframework.security.core.userdetails.UserDetails;

import com.cda.springsecurity.tp_back.model.Utilisateur;

public interface JsonWebTokenService {

    String generateToken(Utilisateur userDetails);
    String extractUserName(String token);
    boolean isTokenValid(String token, UserDetails userDetails);
    boolean isTokenExpired(String token);

}
