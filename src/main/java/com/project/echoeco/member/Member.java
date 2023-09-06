package com.project.echoeco.member;


import javax.persistence.*;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import common.Role;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Data
@Table(name = "member")
public class Member {
	
	@Id
	@Column(name = "member_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)//기본 키 설정
	private Integer id;
	
	@Column(unique = true)
	private String email;
	
	private String password;
	
	private String name;
	
	private Integer tel;
	
	@Enumerated(EnumType.STRING) //DB에 저장될 때 문자로 저장되게 함
	private Role role;
	
    public static Member createMember(MemberDTO memberDTO, PasswordEncoder passwordEncoder){
        Member member = new Member();
        member.setName(memberDTO.getName());
        member.setEmail(memberDTO.getEmail());
        String password = passwordEncoder.encode(memberDTO.getPassword());
        member.setPassword(password);
        member.setRole(Role.MEMBER);
        return member;
    }
	
}
