package com.project.echoeco.utils;

import java.util.Date;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JwtUtil {

  public static String getEmail(String token, String secretKey) {
    return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody().get("email", String.class);
  }

  public static boolean isExpired(String token, String secretKey) {
    return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody().getExpiration().before(new Date());
  };

  public static String createToken(String email, String secretKey, Long expiredMs) {
    Claims claims = Jwts.claims();
    claims.put("email", email);
    return Jwts.builder()
        .setClaims(claims)
        .setIssuedAt(new Date(System.currentTimeMillis()))
        .setExpiration(new Date(System.currentTimeMillis() + expiredMs))
        .signWith(SignatureAlgorithm.HS256, secretKey)
        .compact();
  }

}
