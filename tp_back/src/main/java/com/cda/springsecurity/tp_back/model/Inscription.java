package com.cda.springsecurity.tp_back.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Inscription {
    
    private String email;
    private String mdp;
    
}
