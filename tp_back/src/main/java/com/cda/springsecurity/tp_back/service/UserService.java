package com.cda.springsecurity.tp_back.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.cda.springsecurity.tp_back.model.User;

public interface UserService {
    UserDetailsService userDetailsService();
    
    User save(User utilisateur);

    User getById(long idUtilisateur);
    User getByEmail(String email);

    boolean existsByEmail(String email);

    User getByRoleId(long idRole);

}
