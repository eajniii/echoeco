package com.project.echoeco.member;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.security.crypto.password.PasswordEncoder;

import com.project.echoeco.board.Board;
import com.project.echoeco.common.Role;

import lombok.Builder;
import lombok.Data;

@Entity
@Data
@Table(name = "member")
public class Member {

	@Id
	@Column(name = "member_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(unique = true)
	private String email;

	private String password;

	@OneToOne(targetEntity = Board.class)
	private String name;

	private Integer tel;

	@Enumerated(EnumType.STRING)
	private Role role;

	public static Member createMember(MemberDTO memberDTO, PasswordEncoder passwordEncoder) {
		Member member = new Member();
		member.setName(memberDTO.getName());
		member.setEmail(memberDTO.getEmail());
		String password = passwordEncoder.encode(memberDTO.getPassword());
		member.setPassword(password);
		member.setRole(Role.MEMBER);
		return member;
	}

}
