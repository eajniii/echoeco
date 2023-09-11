package com.project.echoeco.member;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.project.echoeco.board.Board;
import com.project.echoeco.common.BaseMember;
import com.project.echoeco.common.constant.Role;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Entity
@SuperBuilder
@ToString
@Getter
@Table(name = "member")
@NoArgsConstructor(access = AccessLevel.PROTECTED)

public class Member extends BaseMember{

	@Id
	@Column(name = "memberId")
	@GeneratedValue(strategy = GenerationType.IDENTITY) // 기본 키 설정
	private Integer id;

	@Column(unique = true)
	private String email;

	private String password;

	@OneToOne(targetEntity = Board.class)
	private String name;

	private Integer tel;

	@Enumerated(EnumType.STRING)
	private Role role;

}
