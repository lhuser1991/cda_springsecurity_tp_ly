package com.cda.springsecurity.tp_back.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.cda.springsecurity.tp_back.model.Inscription;
import com.cda.springsecurity.tp_back.model.Role;
import com.cda.springsecurity.tp_back.model.Utilisateur;
import com.cda.springsecurity.tp_back.service.InscriptionService;

@Service
public class InscriptionServiceImpl implements InscriptionService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UtilisateurServiceImpl utilisateurServiceImpl;

    @Autowired
    private RoleServiceImpl roleServiceImpl;

    @Override
    public Utilisateur inscription(Inscription inscription) {
        
        if(utilisateurServiceImpl.existsByEmail(inscription.getEmail())) {
            throw new RuntimeException("Email deja utilisé.");
        }

        Role userRole = roleServiceImpl.getByNom("UTILISATEUR");
        String encryptedMdp = passwordEncoder.encode(inscription.getMdp());
        Utilisateur newUtilisateur = new Utilisateur(0, inscription.getNom(), inscription.getPrenom(), inscription.getEmail(), encryptedMdp, true, userRole);

        return utilisateurServiceImpl.save(newUtilisateur);
    }
    
}
