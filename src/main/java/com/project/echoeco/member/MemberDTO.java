package com.project.echoeco.member;

import java.time.LocalDateTime;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class MemberDTO {

	@Email(message = "이메일 형식에 맞춰 입력해주세요")
	@NotEmpty(message = "이메일을 입력해주세요")	//null , 빈 문자열(스페이스 포함 X) 불가
	private String email;
	
	@Pattern(regexp = "(?=.*[0-9])(?=.*[a-zA-Z])(?=.*\\W)(?=.*S+$)",
			message = "숫자,영문 대,소문자,특수기호 포함하여 비밀번호를 작성해주세요")
	@NotEmpty(message = "비밀번호를 입력해주세요")
	private String password;
	
	
	@NotEmpty(message = "이름을 입력해주세요")	

	@NotEmpty(message = "이름을 입력해주세요")
	private String name;
	
	// NotBlank(message = "연락가능한 휴대번호를 - 또는 공백 없이 숫자만 입력해주세요") //null , 빈 문자열 ,
	// 스페이스만 포함한 문자열 불가
	private Integer tel;
	
	private LocalDateTime created_date;

}
