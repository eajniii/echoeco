package com.project.echoeco.member;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

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
	@Column(name = "memberId")
	@GeneratedValue(strategy = GenerationType.IDENTITY) // 기본 키 설정
	private Integer id;

	@Column(unique = true)
	private String email;

	private String password;

	private String name;

	private Integer tel;

	@Enumerated(EnumType.STRING) // DB에 저장될 때 문자로 저장되게 함
	private Role role;
}
