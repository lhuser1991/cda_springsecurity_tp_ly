package com.cda.springsecurity.tp_back.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
@Entity
@Table(name = "roles")
public class Role {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    private String description;

    private boolean actif;

    @JsonIgnore
    @OneToMany(mappedBy = "role")
    private List<User> listUser;

    public Role() {
        this.id = 0;
        this.name = "";
        this.description = "";
        this.actif = false;
        this.listUser = new ArrayList<User>();
    }

    /**
     * Constructeur utilisé pour initialiser la table role dans la bdd
     * @param nom
     * @param description
     */
    public Role(String nom, String description) {
        this.id = 0;
        this.name = nom;
        this.description = description;
        this.actif = true;
        this.listUser = new ArrayList<User>();
    }
    
}
