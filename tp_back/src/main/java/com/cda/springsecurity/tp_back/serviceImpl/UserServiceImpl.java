package com.cda.springsecurity.tp_back.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.cda.springsecurity.tp_back.model.User;
import com.cda.springsecurity.tp_back.repository.UserRepository;
import com.cda.springsecurity.tp_back.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository utilisateurRepository;

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
    public User save(User utilisateur) {
        return utilisateurRepository.save(utilisateur);
    }

    @Override
    public User getById(long idUtilisateur) {
        return utilisateurRepository.findById(idUtilisateur).orElse(new User());
    }

    @Override
    public boolean existsByEmail(String email) {
        return utilisateurRepository.existsByEmail(email);
    }

    @Override
    public User getByEmail(String email) {
        return utilisateurRepository.findByEmail(email).orElse(new User());
    }

    @Override
    public User getByRoleId(long idRole) {
        return utilisateurRepository.findByRoleId(idRole).orElse(new User());
    }
    
}
