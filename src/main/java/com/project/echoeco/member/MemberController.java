package com.project.echoeco.member;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {

	private MemberService memberService;
	
	@GetMapping("/signup")
	private String signup(MemberDTO memberDTO) {
		return "/signup";
	}

	
	//비밀번호 유효성 검사 실패
	private String failsignup(@Valid MemberDTO memberDTO,Errors errors,Model model) {
		//회원가입 실패 시 , 입력 데이터 유지 (프론트단에서 thymleaf 사용)
		if(errors.hasErrors()) {
			model.addAttribute("memberDTO",memberDTO);
			
		//유효성 통과 못한 필드 필드와 메세지 핸들링 - 예외 처리 (패스워드 유효성 검사)
		Map<String,String> validatorResult = memberservice.validatehandling(errors);
		for(String key:validatorResult.keySet()) {
			model.addAttribute(key,validatorResult.get(key));
		}
			
			
		}
	}
	
}
