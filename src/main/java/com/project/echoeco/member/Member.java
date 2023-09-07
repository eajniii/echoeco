package com.project.echoeco.member;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.security.crypto.password.PasswordEncoder;

import com.project.echoeco.common.BaseTime;
import com.project.echoeco.common.constant.Role;

import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Entity
@SuperBuilder
@ToString
@Getter
@Table(name = "member")
public class Member extends BaseTime {

	@Id
	@Column(name = "member_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY) // 기본 키 설정
	private Integer id;

	@Column(unique = true)
	private String email;

	private String password;

	private String name;

	private Integer tel;

	@Enumerated(EnumType.STRING) // DB에 저장될 때 문자로 저장되게 함
	private Role role;

	public static Member createMember(MemberDTO memberDTO, PasswordEncoder passwordEncoder) {
		Member member = Member.builder()
				.name(memberDTO.getName())
				.email(memberDTO.getEmail())
				.password(passwordEncoder.encode(memberDTO.getPassword()))
				.tel(memberDTO.getTel())
				.role(Role.MEMBER)
				.build();
		return member;
	}

}
