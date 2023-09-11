package com.project.echoeco.member;

import java.time.LocalDateTime;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.project.echoeco.common.constant.Role;
import com.project.echoeco.common.exception.AppException;
import com.project.echoeco.common.exception.ErrorCode;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberService {

	private final MemberRepository memberRepository;
	private final BCryptPasswordEncoder encoder;

	public Member join(MemberJoinRequest dto) {
		memberRepository.findByEmail(dto.getEmail())
				.ifPresent(member -> {
					throw new AppException(ErrorCode.MEMBER_DUPLICATED,
							dto.getEmail() + "는 이미 등록되었습니다.");
				});

		Member member = Member.builder()
				.email(dto.getEmail())
				.name(dto.getName())
				.password(encoder.encode(dto.getPassword()))
				.role(Role.MEMBER)
				.createdAt(LocalDateTime.now())
				.build();

		Member savedMember = memberRepository.save(member);

		return savedMember;

	}

	public String login(String email, String password) {
		memberRepository.findByEmail(email).isPresent(

		);

		return "hi";
	}
	// 회원 정보 저장
	// public Member saveMember(MemberDTO dto) {
	// validateDuplicateMember(dto);
	// return memberRepository.save(dto);
	// }

	// // 중복성 검사 , email 중복인 경우 오류 메세지
	// private void validateDuplicateMember(Member member) {
	// Optional<Member> findMember =
	// memberRepository.findByEmail(member.getEmail());
	// if (findMember != null) {
	// throw new IllegalStateException("이미 가입된 회원입니다.");
	// }
	// }

	// // //유효성 검사에 실패한 필드 목록 hashmap에 저장

}
