package com.project.echoeco.member;

import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/members")
@RequiredArgsConstructor
public class MemberController {

	private final MemberService memberService;
	private final PasswordEncoder passwordEncoder;

	@PostMapping("/join")
	public ResponseEntity<String> join(@RequestBody MemberJoinRequest dto) {
		memberService.join(dto);
		return ResponseEntity.ok().body("회원가입 완료!");
	}

	@GetMapping("/signup")
	public String signup(MemberDTO memberDTO) {
		return "member/signup";
	}

	// @PostMapping("/signup")
	// public String failsignup(@Valid MemberDTO memberDTO, BindingResult
	// bindingResult, Model model) {
	// // 회원가입 실패 시 , 입력 데이터 유지 (프론트단에서 thymleaf 사용)
	// if (bindingResult.hasErrors()) {
	// model.addAttribute("memberDTO", memberDTO);

	// // 유효성 통과 못한 필드 필드와 메세지 핸들링 - 예외 처리 (패스워드 유효성 검사)
	// try {
	// Member member = Member.createMember(memberDTO, passwordEncoder);
	// memberService.saveMember(member);
	// } catch (IllegalStateException e) {
	// model.addAttribute("errorMessage", e.getMessage());
	// return "member/memberDTO";
	// }
	// }
	// return "signup";
	// }

	@GetMapping("/login")
	public String login() {
		return "login";

	}
}
