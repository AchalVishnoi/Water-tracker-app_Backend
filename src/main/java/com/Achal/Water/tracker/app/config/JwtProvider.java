package com.Achal.Water.tracker.app.config;

import io.jsonwebtoken.security.Keys;
import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties;

import javax.crypto.SecretKey;
import java.util.Date;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.security.core.Authentication;


public class JwtProvider {
    private static SecretKey key= Keys.hmacShaKeyFor(JwtConstants.SECRET_KEY.getBytes());
    public static String generateToken(Authentication auth){
        String jwt= Jwts.builder().
                setIssuer("waterTrackerApp").setIssuedAt(new Date()).setExpiration(new Date(new Date().getTime()+86400000))
                .claim("email",auth.getName())
                .signWith(key)
                .compact();

        return jwt;
    }

    public static String getEmailFromJwtToken(String jwt) {

        jwt = jwt.substring(7);

        Claims claims=Jwts.parser().setSigningKey(key).build().parseClaimsJws(jwt ).getBody();




        return String.valueOf(claims.get("email"));
    }


}
