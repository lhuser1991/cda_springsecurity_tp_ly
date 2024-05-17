package com.cda.springsecurity.tp_back.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.cda.springsecurity.tp_back.model.Utilisateur;
import com.cda.springsecurity.tp_back.repository.UtilisateurRepository;
import com.cda.springsecurity.tp_back.service.UtilisateurService;

@Service
public class UtilisateurServiceImpl implements UtilisateurService {

    @Autowired
    private UtilisateurRepository utilisateurRepository;

    @Override
    public UserDetailsService userDetailsService() {
        return new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String username) {
                return utilisateurRepository.findByEmail(username).orElseThrow(() -> new UsernameNotFoundException("User not found"));
            }
        };
    }

    @Override
    public Utilisateur save(Utilisateur utilisateur) {
        return utilisateurRepository.save(utilisateur);
    }

    @Override
    public Utilisateur getById(long idUtilisateur) {
        return utilisateurRepository.findById(idUtilisateur).orElse(new Utilisateur());
    }

    @Override
    public boolean existsByEmail(String email) {
        return utilisateurRepository.existsByEmail(email);
    }

    @Override
    public Utilisateur getByEmail(String email) {
        return utilisateurRepository.findByEmail(email).orElse(new Utilisateur());
    }
    
}
