package com.cda.springsecurity.tp_back.service;

import com.cda.springsecurity.tp_back.model.Role;

public interface RoleService {
    
    Role save(Role role);
    Role create(Role role);

    Role getByNom(String nomRole);
}
