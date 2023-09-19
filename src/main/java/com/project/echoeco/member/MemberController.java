package com.project.echoeco.member;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.echoeco.member.auth.PasswordChangeRequest;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequiredArgsConstructor
@RequestMapping("/member")
@Slf4j
@CrossOrigin(originPatterns = "http://localhost:3000")
public class MemberController {
	private final MemberService memberService;

	@GetMapping("/mypage")
	public ResponseEntity<MemberInfoResponse> getMemberInfo() {
		MemberInfoResponse mypageBySecurity = memberService.getMypageBySecurity();
		log.info(mypageBySecurity.getNickname());

		return ResponseEntity.ok(memberService.getMypageBySecurity());
	}

	@PostMapping("/modify/nickname")
	public ResponseEntity<MemberInfoResponse> changeNickname(@RequestBody MemberRequest dto) {
		return ResponseEntity.ok(memberService.changeMemberNickname(dto.getEmail(), dto.getNickname()));
	}

	@PostMapping("/modify/password")
	public ResponseEntity<MemberInfoResponse> changePassword(@RequestBody PasswordChangeRequest dto) {
		return ResponseEntity
				.ok(memberService.changeMemberPassword(dto.getEmail(), dto.getExPassword(), dto.getNewPassword()));
	}
}
