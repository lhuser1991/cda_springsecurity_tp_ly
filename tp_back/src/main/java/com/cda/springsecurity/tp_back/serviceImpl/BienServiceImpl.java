package com.cda.springsecurity.tp_back.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cda.springsecurity.tp_back.model.Bien;
import com.cda.springsecurity.tp_back.repository.BienRepository;
import com.cda.springsecurity.tp_back.service.BienService;

@Service
public class BienServiceImpl implements BienService {

    @Autowired
    private BienRepository bienRepository;

    @Override
    public Bien save(Bien bien) {
        return bienRepository.save(bien);
    }

    @Override
    public Bien update(Bien bien) {
        Bien oldBien = getById(bien.getId());
        if(oldBien.getId() != 0) {
            Bien updatedBien = new Bien(oldBien.getId(), bien.getDescription(), bien.getPrix(), bien.getSurface(), bien.getNbPiece(), bien.getNbChambre(), bien.getVille(), bien.getCodePostale(), bien.getLienPhoto());
            return save(updatedBien);
        }
        return oldBien;
    }

    @Override
    public Bien getById(long idBien) {
        return bienRepository.findById(idBien).orElse(new Bien());
    }

    @Override
    public List<Bien> getAll() {
        return bienRepository.findAll();
    }

    @Override
    public List<Bien> getAllUnderSurface(float surface) {
        List<Bien> allBien = getAll();
        return allBien.stream().filter(bien -> bien.getSurface() < surface).toList();
    }

    @Override
    public List<Bien> getAllAboveSurface(float surface) {
        List<Bien> allBien = getAll();
        return allBien.stream().filter(bien -> bien.getSurface() > surface).toList();
    }

    @Override
    public List<Bien> getAllBetweenSurface(float higherSurface, float lowerSurface) {
        List<Bien> allBien = getAll();
        return allBien.stream()
            .filter(bien -> bien.getSurface() < higherSurface)
            .filter(bien -> bien.getSurface() > lowerSurface)
            .toList();
    }

    @Override
    public List<Bien> getAllUnderPrix(float prix) {
        List<Bien> allBien = getAll();
        return allBien.stream().filter(bien -> bien.getPrix() < prix).toList();
    }

    @Override
    public List<Bien> getAllAbovePrix(float prix) {
        List<Bien> allBien = getAll();
        return allBien.stream().filter(bien -> bien.getPrix() > prix).toList();
    }

    @Override
    public List<Bien> getAllBetweenPrix(float higherPrix, float lowerPrix) {
        List<Bien> allBien = getAll();
        return allBien.stream()
            .filter(bien -> bien.getPrix() < higherPrix)
            .filter(bien -> bien.getPrix() > lowerPrix)
            .toList();
    }
    
}
