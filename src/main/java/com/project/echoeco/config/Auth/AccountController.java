package com.project.echoeco.config.Auth;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/oauth")
public class AccountController {

	@Autowired
	AccountService accountService;
	
	@GetMapping("/user/info")
	public ResponseEntity getUSerInfo(Principal principal) {
		Account account = accountService.getAccount(Long.valueOf(principal.getName()));
		return ResponseEntity.ok().body(AccountDTO.convertToDTO(account));
	}
	
}
