package com.cda.springsecurity.tp_back.dataInit;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.cda.springsecurity.tp_back.model.Role;
import com.cda.springsecurity.tp_back.model.User;
import com.cda.springsecurity.tp_back.serviceImpl.RoleServiceImpl;
import com.cda.springsecurity.tp_back.serviceImpl.UserServiceImpl;

@Component
public class DataLoad implements CommandLineRunner {

    @Autowired
    private RoleServiceImpl roleServiceImpl;

    @Autowired
    private UserServiceImpl utilisateurServiceImpl;

    public void run(String... args) {
        
        List<Role> allRole = roleServiceImpl.getAll();
        if(allRole.size() == 0) {
            List<Role> listRole = new ArrayList<Role>();

            Role adminRole = new Role(0, "ADMIN", "Administrateur", true, new ArrayList<User>());
            Role utilisateurRole = new Role(0, "USER", "Utilisateur", true, new ArrayList<User>());

            listRole.add(adminRole);
            listRole.add(utilisateurRole);

            roleServiceImpl.saveAll(listRole);
        }

        Role adminRole = roleServiceImpl.getByNom("ADMIN");
        User adminUtilisateur = utilisateurServiceImpl.getByRoleId(adminRole.getId());
        if(adminUtilisateur.getId() == 0) {
            String encryptedAdminMdp = new BCryptPasswordEncoder().encode("admin");
            User newAdmin = new User(0, "ADMIN", "admin", "admin@monmail.com", encryptedAdminMdp, true, adminRole);
            utilisateurServiceImpl.save(newAdmin);
        }
    }
    
}
