package com.project.echoeco.member;

import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor	
public class MemberService {

	private final MemberRepository memberRepository;
	
	
	//회원 정보 저장
	public Member saveMember(Member member) {
		validateDuplicateMember(member);
		return memberRepository.save(member);
	}
	
	//중복성 검사 , email 중복인 경우 오류 메세지
	private void validateDuplicateMember(Member member) {
		Optional<Member> findMember = memberRepository.findByEmail(member.getEmail());
		if(findMember != null) {
			throw new IllegalStateException("이미 가입된 회원입니다.");
		}
	}
	
	
//	//유효성 검사에 실패한 필드 목록 hashmap에 저장

	
}
