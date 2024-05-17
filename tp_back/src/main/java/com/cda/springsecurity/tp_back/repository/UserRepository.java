package com.cda.springsecurity.tp_back.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cda.springsecurity.tp_back.model.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long>{

    Optional<User> findByEmail(String email);
    Optional<User> findByRoleId(long idRole);
    List<User> findAllByActif(boolean actif);
    boolean existsByEmail(String email);
    
}
