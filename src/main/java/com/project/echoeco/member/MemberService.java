package com.project.echoeco.member;

import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor	
public class MemberService {
	private final MemberRepository memberRepository;
	
	//회원 정보 저장
	private Member saveMember(Member member) {
		validateDuplicateMember(member);
		return memberRepository.save(member);
	}
	
	//중복성 검사 , email 중복인 경우 오류 메세지
	private void validateDuplicateMember(Member member) {
		Member findMember = memberRepository.findbyEmail(member.getEmail());
		if(findMember != null) {
			throw new IllegalStateException("이미 가입된 회원입니다.");
		}
	}
	
	
	@Transactional(readOnly = true)
	public Map<String,String> validatehandling(Errors errors){
		Map<String,String> validatorResult = new hashMap<>();
	
		//유효성 검사에 실패한 필드 목록
		
		
	return validatorResult;
	}
	
	
}
