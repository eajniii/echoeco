package com.project.echoeco.config.Auth.config;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.stereotype.Component;

import com.project.echoeco.config.Auth.Account;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@Component
public class JWTUtils {

	private static final long TOKEN_VALIDITY = 86400000L; //10,000일
	private static final long TOKEN_VALIDITY_REMEMBER = 2592000000L; //30,000일
	private final Key key;
	
	public JWTUtils(@Value("${jwt.Secret}") String secret) {
		this.key = Keys.hmacShaKeyFor(secret.getBytes());
		
	}
	
	public String createToken(Account account,boolean rememberMe) {
		long now = (new Date()).getTime();
		Date validity = rememberMe ? new Date(now + TOKEN_VALIDITY_REMEMBER) : new Date(now + TOKEN_VALIDITY);
		Map<String,Object> claims = new HashMap<>();
		claims.put("role", account.getRoles());
		
		return Jwts.builder()
				.setSubject(account.getId().toString())
				.setIssuedAt(new Date())	//발급시간
				.setExpiration(validity)	//만료기간
				.setClaims(claims)			//정보
				.signWith(key,SignatureAlgorithm.HS512)	
				.compact();
	}
	
	public Authentication verifyAuthentication(String token) {
		try {
			Claims claims = Jwts.parserBuilder()
					.setSigningKey(key)
					.build()
					.parseClaimsJws(token)
					.getBody();
			List<GrantedAuthority> authorities = AuthorityUtils.commaSeparatedStringToAuthorityList(claims.get("role",String.class));
			return new UsernamePasswordAuthenticationToken(claims.getSubject(),token, authorities);
			}catch(JwtException | IllegalArgumentException ignored) {
				return null;
			}
	}
}
