package com.project.echoeco.member.auth;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.echoeco.config.Token.TokenCreation;
import com.project.echoeco.member.MemberInfoResponse;
import com.project.echoeco.member.MemberRequest;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
@CrossOrigin(originPatterns = "http://localhost:3000")
public class AuthController {

	private final AuthService authService;

	@PostMapping("/signup")
	public ResponseEntity<MemberInfoResponse> signup(@RequestBody MemberRequest dto) {

		return ResponseEntity.ok(authService.signup(dto));
	}

	@PostMapping("/login")
	public ResponseEntity<TokenCreation> login(@RequestBody MemberRequest dto) {
		return ResponseEntity.ok(authService.login(dto));
	}

	@GetMapping("/logout")
	public String logout(HttpServletRequest request, HttpServletResponse response) {
		new SecurityContextLogoutHandler().logout(request, response,
				SecurityContextHolder.getContext().getAuthentication());
		return "redirect:/";
	}
}
