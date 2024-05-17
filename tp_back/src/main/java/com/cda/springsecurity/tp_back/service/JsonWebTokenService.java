package com.cda.springsecurity.tp_back.service;

import org.springframework.security.core.userdetails.UserDetails;

import com.cda.springsecurity.tp_back.model.User;

public interface JsonWebTokenService {

    String generateToken(User userDetails);
    String extractUserName(String token);
    boolean isTokenValid(String token, UserDetails userDetails);
    boolean isTokenExpired(String token);

}
