package com.project.echoeco.member;

import javax.validation.Valid;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {

	private final MemberService memberService;
	private final PasswordEncoder passwordEncoder;
	
	@GetMapping("/signup")
	public String signup(MemberDTO memberDTO) {
		return "signup";
	}

	
	@PostMapping("/signup")
	public String failsignup(@Valid MemberDTO memberDTO,BindingResult bindingResult,Model model) {
		//회원가입 실패 시 , 입력 데이터 유지 (프론트단에서 에러처리)
		if(bindingResult.hasErrors()) {
			model.addAttribute("memberDTO",memberDTO);
			
		//유효성 통과 못한 필드 필드와 메세지 핸들링 - 예외 처리 (패스워드 유효성 검사)
		try {
				Member member = Member.createMember(memberDTO,passwordEncoder);
				memberService.saveMember(member);
			}catch(IllegalStateException e) {
				model.addAttribute("errorMessage",e.getMessage());
				return "member/memberDTO";
			}
		}
		return "signup";	
		}
	
	@GetMapping("/login")
	public String login() {
		return "Login";
		
	}
}
