package com.ud.userservice.security;

import com.ud.userservice.entities.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.security.Key;
import java.util.Date;
import java.util.function.Function;

public class Jwt {
    private static String SECRET_KEY = "uddhav";

    public static String generateToken(User user) {
        String role = (user.getUserType().equals("user")) ? "user" : "admin";
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;

        byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(SECRET_KEY);
        Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());

        String token = Jwts.builder().setId(user.getId().toString())
                .setIssuer(user.getUsername())
                .setSubject(role)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 600000))
                .signWith(signatureAlgorithm, signingKey)
                .compact();

        return token;
    }

    public static Claims decodeToken(String token) {
        Claims claims = null;
        try {
            Claims decoded = Jwts.parser()
                    .setSigningKey(DatatypeConverter.parseBase64Binary(SECRET_KEY))
                    .parseClaimsJws(token).getBody();
            claims = decoded;
        } catch(Exception e) {
            e.printStackTrace();
        }
        return claims;
    }

    public static <T> T getClaimFromToken(Claims claims, Function<Claims, T> claimsResolver) {
        return claimsResolver.apply(claims);
    }

    public static String validate(Claims claims) {
        Date expiration = getClaimFromToken(claims, Claims::getExpiration);
        if (!expiration.before(new Date())) {
            return getClaimFromToken(claims, Claims::getSubject);
        } else {
            return "tokenExpired";
        }
    }
}
