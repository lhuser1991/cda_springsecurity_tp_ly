package com.cda.springsecurity.tp_back.serviceImpl;

import java.security.Key;
import java.util.Date;
import java.util.function.Function;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.cda.springsecurity.tp_back.model.Utilisateur;
import com.cda.springsecurity.tp_back.service.JsonWebTokenService;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Service
public class JsonWebTokenServiceImpl implements JsonWebTokenService {
    
    @Override
    public String generateToken(Utilisateur userDetails) {

        return Jwts.builder()
            .setSubject(userDetails.getUsername())
            .setId(String.valueOf(userDetails.getId()))
            .claim("id",userDetails.getId())
            .claim("nom", userDetails.getNom())
            .claim("prenom", userDetails.getPrenom())
            .claim("idRole", userDetails.getRole().getId())
            .setIssuedAt(new Date(System.currentTimeMillis()))
            .setExpiration(new Date(System.currentTimeMillis() + 12*60*60*1000))
            .signWith(getSigninKey(), SignatureAlgorithm.HS256)
            .compact();
    }
    
    @Override
    public String extractUserName(String token) {
        return extractClaims(token, Claims::getSubject);
    }

    @Override
    public boolean isTokenValid(String token, UserDetails userDetails) {
        final String username = extractUserName(token);
        return(username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }

    @Override
    public boolean isTokenExpired(String token) {
        return extractClaims(token, Claims::getExpiration).before(new Date());
    }
    
    private <T> T extractClaims(String token, Function<Claims, T> claimsResolvers) {
        final Claims claims = extractAllClaims(token);
        return claimsResolvers.apply(claims);
    }

    public Key getSigninKey() {
        byte[] key = Decoders.BASE64.decode("fgG2xM/CvNir0PXdv79arocwJij4T2UyMuvMounCjBQ");
        return Keys.hmacShaKeyFor(key);
    }

    private Claims extractAllClaims(String token) {
        return Jwts.parserBuilder().setSigningKey(getSigninKey()).build().parseClaimsJws(token).getBody();
    }

    public String extractUserId(String token) {
        return extractClaims(token, Claims::getId);
    }
}
