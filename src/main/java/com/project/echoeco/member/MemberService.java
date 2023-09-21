package com.project.echoeco.member;

import javax.transaction.Transactional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.project.echoeco.common.exception.AppException;
import com.project.echoeco.common.exception.ErrorCode;
import com.project.echoeco.config.SecurityUtil;
import com.project.echoeco.member.auth.MemberRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberService {

	private final MemberRepository memberRepository;
	private final PasswordEncoder encoder;

	public MemberInfoResponse getMypageBySecurity() {
		return memberRepository.findById(SecurityUtil.getCurrentMemberId())
				.map(MemberInfoResponse::fromMember)
				.orElseThrow(() -> new AppException(ErrorCode.UNKNOWN_MEMBER, ErrorCode.UNKNOWN_MEMBER.getMessage()));

	}

	@Transactional
	public MemberInfoResponse changeMemberNickname(String email, String nickname) {
		Member member = memberRepository.findByEmail(email)
				.orElseThrow(() -> new AppException(ErrorCode.UNKNOWN_MEMBER, "로그인 유저 정보가 없습니다."));
		member.modifyNickname(nickname);
		return MemberInfoResponse.fromMember(memberRepository.save(member));
	}

	@Transactional
	public MemberInfoResponse changeMemberPassword(String email, String exPassword, String newPassword) {
		Member member = memberRepository.findByEmail(email)
				.orElseThrow(() -> new AppException(ErrorCode.UNKNOWN_MEMBER, "로그인 유저 정보가 없습니다."));
		if (!encoder.matches(exPassword, member.getPassword())) {
			throw new AppException(ErrorCode.INVALID_PASSWORD, "잘못된 비밀번호 입니다.");
		}
		member.modifyNickname(encoder.encode(newPassword));
		return MemberInfoResponse.fromMember(memberRepository.save(member));
	}

}
