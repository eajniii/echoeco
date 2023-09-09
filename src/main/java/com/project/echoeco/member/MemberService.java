package com.project.echoeco.member;

import java.util.Optional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.echoeco.common.constant.Role;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberService {

	private final MemberRepository memberRepository;

	// 회원 정보 저장
	public Member saveMember(MemberDTO memberDTO, PasswordEncoder passwordEncoder) {
		
		validateDuplicateMember(memberDTO);
		
		Member member = Member.builder()
				.name(memberDTO.getName())
				.email(memberDTO.getEmail())
				.password(passwordEncoder.encode(memberDTO.getPassword()))
				.tel(memberDTO.getTel())
				.role(Role.MEMBER)
				.build();
		return memberRepository.save(member);
	}
	

	// 중복성 검사 , email 중복인 경우 오류 메세지
	private void validateDuplicateMember(MemberDTO memberDTO) {
		Optional<Member> findMember = memberRepository.findByEmail(memberDTO.getEmail());
		if (findMember != null) {
			throw new IllegalStateException("이미 가입된 회원입니다.");
		}
	}


}
