package com.cda.springsecurity.tp_back.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import com.cda.springsecurity.tp_back.model.Connexion;
import com.cda.springsecurity.tp_back.model.JsonWebToken;
import com.cda.springsecurity.tp_back.model.User;
import com.cda.springsecurity.tp_back.service.ConnexionService;

@Service
public class ConnexionServiceImpl implements ConnexionService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserServiceImpl utilisateurServiceImpl;

    @Autowired
    private JsonWebTokenServiceImpl jsonWebTokenServiceImpl;

    @Override
    public JsonWebToken connexion(Connexion connexion) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(connexion.getEmail(), connexion.getMdp()));

        User utilisateur = utilisateurServiceImpl.getByEmail(connexion.getEmail());

        String jwt = jsonWebTokenServiceImpl.generateToken(utilisateur);

        JsonWebToken jsonWebToken = new JsonWebToken();
        jsonWebToken.setJwt(jwt);

        return jsonWebToken;

    }
    
}
