package com.project.echoeco.config.Auth;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AccountDTO {

	private String firstName;
	
	private String lastName;
	
	private String email;
	
	public static final AccountDTO convertToDTO(Account account) {
		return AccountDTO.builder()
				.firstName(account.getFirstName())
				.lastName(account.getLastName())
				.email(account.getEmail())
				.build();
	}
}
