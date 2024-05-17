package com.cda.springsecurity.tp_back.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.cda.springsecurity.tp_back.model.Utilisateur;

public interface UtilisateurService {
    UserDetailsService userDetailsService();
    
    Utilisateur save(Utilisateur utilisateur);

    Utilisateur getById(long idUtilisateur);
    Utilisateur getByEmail(String email);

    boolean existsByEmail(String email);

    Utilisateur getByRoleId(long idRole);

}
