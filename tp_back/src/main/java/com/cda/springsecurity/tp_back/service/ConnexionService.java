package com.cda.springsecurity.tp_back.service;

import com.cda.springsecurity.tp_back.model.Connexion;
import com.cda.springsecurity.tp_back.model.JsonWebToken;

public interface ConnexionService {

    JsonWebToken connexion(Connexion connexion);
    
}
