package com.project.echoeco.config.Auth;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.project.echoeco.config.Auth.config.JWTUtils;

@Service
public class AccountService {

	private final AccountRepository accountRepository;
	private final JWTUtils jwtUtils;
	private final GoogleIdTokenVerifier verifier;
	
							//application.property
	public AccountService(@Value("${google.ClientId}") String clientId,AccountRepository accountRepository,JWTUtils jwtUtils) {
		this.accountRepository = accountRepository;
		this.jwtUtils = jwtUtils;
		NetHttpTransport transport = new NetHttpTransport();
		JsonFactory jsonFactory = new JacksonFactory();
		verifier = new GoogleIdTokenVerifier.Builder(transport, jsonFactory)
				.setAudience(Collections.singletonList(clientId))
				.build();
	}
	
	public Account getAccount(Long id) {
		return accountRepository.findById(id).orElse(null);
	}
}
