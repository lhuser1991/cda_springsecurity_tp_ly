package com.cda.springsecurity.tp_back.service;

import java.util.List;

import com.cda.springsecurity.tp_back.model.Bien;

public interface BienService {
    
    Bien save(Bien bien);
    Bien update(Bien bien);

    Bien getById(long idBien);
    List<Bien> getAll();

    List<Bien> getAllUnderSurface(float surface);
    List<Bien> getAllAboveSurface(float surface);
    List<Bien> getAllBetweenSurface(float higherSurface, float lowerSurface);

    List<Bien> getAllUnderPrix(float prix);
    List<Bien> getAllAbovePrix(float prix);
    List<Bien> getAllBetweenPrix(float higherPrix, float lowerPrix);

}
