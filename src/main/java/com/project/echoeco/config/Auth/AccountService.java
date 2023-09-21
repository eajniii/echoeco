package com.project.echoeco.config.Auth;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Collections;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
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
	//id 통해서 계정 찾기
	public Account getAccount(Long id) {
		return accountRepository.findById(id).orElse(null);
	}
	
	//구글로그인
	public String loginOAuthGoogle(IdTokenRequestDTO requestBody) {
		Account account = verifyIDToken(requestBody.getIdToken());
		if(account == null) {
			throw new IllegalArgumentException();
		}
		account = createOrUpdateUser(account);
		return jwtUtils.createToken(account, false);
	}
	
	public Account createOrUpdateUser(Account account) {
		Account existingAccount = accountRepository.findByEmail(account.getEmail()).orElse(null);
		if(existingAccount == null) {
			account.builder().roles("ROLE_USER").build();
			accountRepository.save(account);
			return account;
		}
		existingAccount = Account.builder()
				.firstName(account.getFirstName())
				.lastName(account.getLastName())
				.email(account.getEmail())
				.pictureUrl(account.getPictureUrl())
				.build();
		accountRepository.save(existingAccount);
		return existingAccount;
	}
	
	private Account verifyIDToken(String idToken) {
		
		try {
			GoogleIdToken idTokenObj = verifier.verify(idToken);
			if(idTokenObj == null) {
				return null;
			}
			GoogleIdToken.Payload payload = idTokenObj.getPayload();
			String firstName = (String) payload.get("이름");
			String lastName = (String) payload.get("성");
			String email = payload.getEmail();
			String pictureUrl = (String) payload.get("picture");
			
			return new Account(firstName,lastName,email,pictureUrl);
		}catch (GeneralSecurityException e) {
			return null;
		}catch( IOException e) {
			e.printStackTrace();
			return null;
		}
	}
	
}
