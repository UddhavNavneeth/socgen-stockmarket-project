package com.ud.gateway.components;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

import javax.xml.bind.DatatypeConverter;
import java.util.Date;
import java.util.function.Function;

public class Jwt {
    private static String SECRET_KEY = "uddhav";

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
