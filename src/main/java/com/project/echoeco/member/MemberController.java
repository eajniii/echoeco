package com.project.echoeco.member;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class MemberController {

	private MemberService memberservice;
	
	@ResponseBody
	@GetMapping("/member/signup")
	private String signup(MemberDTO memberDTO) {
		return "/signup";
	}
	
}
