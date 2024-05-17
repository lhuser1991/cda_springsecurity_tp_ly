package com.cda.springsecurity.tp_back.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cda.springsecurity.tp_back.model.Role;
import com.cda.springsecurity.tp_back.model.Utilisateur;
import com.cda.springsecurity.tp_back.repository.RoleRepository;
import com.cda.springsecurity.tp_back.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public Role save(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public Role create(Role role) {
        Role newRole = new Role(0, role.getNom(), role.getDescription(), true, new ArrayList<Utilisateur>());
        return save(newRole);
    }

    @Override
    public Role getByNom(String nomRole) {
        return roleRepository.findByNom(nomRole).orElse(new Role());
    }

    @Override
    public List<Role> getAll() {
        return roleRepository.findAll();
    }

    @Override
    public List<Role> saveAll(List<Role> listRole) {
        return roleRepository.saveAll(listRole);
    }
    
}
