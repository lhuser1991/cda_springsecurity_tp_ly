package com.cda.springsecurity.tp_back.service;

import com.cda.springsecurity.tp_back.model.Inscription;
import com.cda.springsecurity.tp_back.model.Utilisateur;

public interface InscriptionService {

    Utilisateur inscription(Inscription inscription);

}
