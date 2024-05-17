package com.cda.springsecurity.tp_back.service;

import java.util.List;

import com.cda.springsecurity.tp_back.model.Role;

public interface RoleService {
    
    Role save(Role role);
    List<Role> saveAll(List<Role> listRole);
    Role create(Role role);

    Role getByNom(String nomRole);
    List<Role> getAll();
}
