package com.project.echoeco.config.Token;

import java.security.Key;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.project.echoeco.common.exception.AppException;
import com.project.echoeco.common.exception.ErrorCode;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.UnsupportedJwtException;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.security.SecurityException;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class TokenProvider {

  private static final String AUTHORITIES_KEY = "auth";
  private static final String BEARER_TYPE = "bearer";
  private static final long ACCESS_TOKEN_EXPIRE_TIME = 1000 * 60 * 30;
  private final Key key;

  public TokenProvider(@Value("${jwt.secret}") String secretKey) {
    byte[] keyBytes = Decoders.BASE64.decode(secretKey);
    this.key = Keys.hmacShaKeyFor(keyBytes);
  }

  // 토큰 생성
  public TokenCreation generateToken(Authentication authentication) {
    String authorities = authentication.getAuthorities().stream()
        .map(GrantedAuthority::getAuthority)
        .collect(Collectors.joining(","));

    long now = (new Date()).getTime();

    Date tokenExpiresIn = new Date(now + ACCESS_TOKEN_EXPIRE_TIME);

    log.info(tokenExpiresIn.toString());

    String accessToken = Jwts.builder()
        .setSubject(authentication.getName())
        .claim(AUTHORITIES_KEY, authorities)
        .setExpiration(tokenExpiresIn)
        .signWith(key, SignatureAlgorithm.HS512)
        .compact();

    return TokenCreation.builder()
        .grantType(BEARER_TYPE)
        .accessToken(accessToken)
        .tokenExpiresIn(tokenExpiresIn.getTime())
        .build();
  }

  public Authentication getAuthentication(String accessToken) {
    Claims claims = parseClaims(accessToken);

    if (claims.get(AUTHORITIES_KEY) == null) {
      throw new AppException(ErrorCode.EXPIRED_TOKEN);
    }

    Collection<? extends GrantedAuthority> authorities = Arrays
        .stream(claims.get(AUTHORITIES_KEY).toString().split(","))
        .map(SimpleGrantedAuthority::new)
        .collect(Collectors.toList());

    UserDetails principal = new User(claims.getSubject(), "", authorities);
    return new UsernamePasswordAuthenticationToken(principal, "", authorities);
  }

  public boolean validateToken(String token) { // 토큰 검증
    try {
      Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token);
      return true;
    } catch (SecurityException | MalformedJwtException e) {
      log.info("잘못된 JWT 서명입니다. 다시 시도하세요.");
    } catch (ExpiredJwtException e) {
      log.info("만료된 토큰입니다.  다시 시도하세요.");
    } catch (UnsupportedJwtException e) {
      log.info(("지원되지 않는 토큰입니다. 다시 시도하세요."));
    } catch (IllegalArgumentException e) {
      log.info("잘못된 토큰입니다. 다시 시도하세요.");
    }
    return false;
  }

  private Claims parseClaims(String accessToken) { // 토큰을 claims 형태로 만듬, 권한 정보 체크
    try {
      return Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(accessToken).getBody();
    } catch (ExpiredJwtException e) {
      return e.getClaims();
    }
  }
}
