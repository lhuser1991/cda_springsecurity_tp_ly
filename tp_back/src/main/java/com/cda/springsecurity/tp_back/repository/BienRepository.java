package com.cda.springsecurity.tp_back.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cda.springsecurity.tp_back.model.Bien;

@Repository
public interface BienRepository extends JpaRepository<Bien,Long> {
    

    
}
