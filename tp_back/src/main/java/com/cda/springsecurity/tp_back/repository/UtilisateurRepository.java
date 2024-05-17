package com.cda.springsecurity.tp_back.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cda.springsecurity.tp_back.model.Utilisateur;

@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur,Long>{

    Optional<Utilisateur> findByEmail(String email);
    Optional<Utilisateur> findByRoleId(long idRole);
    Utilisateur findByRoleNom(long nomRole);
    List<Utilisateur> findAllByActif(boolean actif);
    boolean existsByEmail(String email);
    
}
