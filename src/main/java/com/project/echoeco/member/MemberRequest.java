package com.project.echoeco.member;

import java.time.LocalDateTime;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.project.echoeco.common.constant.Role;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MemberRequest {

	@Email(message = "이메일 형식에 맞춰 입력해주세요")
	@NotEmpty(message = "이메일을 입력해주세요") // null , 빈 문자열(스페이스 포함 X) 불가
	private String email;

	@Pattern(regexp = "(?=.*[0-9])(?=.*[a-zA-Z])(?=.*\\W)(?=.*S+$)", message = "숫자,영문 대,소문자,특수기호 포함하여 비밀번호를 작성해주세요")
	@NotEmpty(message = "비밀번호를 입력해주세요")
	private String password;

	@NotEmpty(message = "이름을 입력해주세요")
	private String nickname;

	public Member toMember(PasswordEncoder passwordEncoder) {
		return Member.builder().email(email).password(passwordEncoder.encode(password))
				.nickname(nickname)
				.role(Role.MEMBER)
				.createdAt(LocalDateTime.now())
				.build();
	}

	public UsernamePasswordAuthenticationToken toAuthentication() {
		return new UsernamePasswordAuthenticationToken(email, password);
	}
}
