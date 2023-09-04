package com.project.echoeco.member;


import javax.persistence.*;

import common.Role;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter @Setter
@ToString
public class Member {
	
	@Id
	@Column(name = "member_id")
	@GeneratedValue(strategy = GenerationType.AUTO)//기본 키 설정
	private Integer id;
	
	@Column(unique = true)
	private String email;
	
	private String password;
	
	private String name;
	
	private Long tel;
	
	private Role role;
	
	
}
