package com.cda.springsecurity.tp_back.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cda.springsecurity.tp_back.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role,Long>{
    
    Role findByNom(String nomRole);
    
}
