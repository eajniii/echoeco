package com.project.echoeco.member;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.project.echoeco.common.constant.Role;
import com.project.echoeco.common.exception.AppException;
import com.project.echoeco.common.exception.ErrorCode;
import com.project.echoeco.utils.JwtUtil;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberService {

	private final MemberRepository memberRepository;
	private final BCryptPasswordEncoder encoder;

	@Value("${jwt.secret}")
	private String secretkey;
	private Long expiredTimeMs = 100 * 60 * 60L;

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
		// email 오류
		Member selectedMember = memberRepository.findByEmail(email)
				.orElseThrow(() -> new AppException(ErrorCode.EMAIL_NOT_FOUND, "등록되지 않은 계정입니다."));

		// pw 오류
		if (!encoder.matches(password, selectedMember.getPassword())) {
			throw new AppException(ErrorCode.INVALID_PASSWORD, "잘못된 패스워드입니다.");
		}

		String token = JwtUtil.createToken(selectedMember.getEmail(), secretkey, expiredTimeMs);

		return token;
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
