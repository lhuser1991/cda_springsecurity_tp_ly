package com.cda.springsecurity.tp_back.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "biens")
public class Bien {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    private String description;

    private float prix;
    
    private float surface;
    
    private int nbPiece;
    
    private int nbChambre;
    
    private String ville;
    
    private int codePostale;
    
    private String lienPhoto;

}
