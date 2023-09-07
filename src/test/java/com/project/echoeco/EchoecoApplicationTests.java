package com.project.echoeco;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.project.echoeco.common.constant.Role;
import com.project.echoeco.member.Member;
import com.project.echoeco.member.MemberRepository;


@SpringBootTest
class EchoecoApplicationTests {

	@Autowired
	private MemberRepository memberRepository;

	
	@Test
	void testJpa() {
	
		Member m1 = Member.builder()
				.name("패트")
				.email("123@123.com")
				.password("1234")
				.tel(12345678)
				.role(Role.MEMBER)
				.build();

		System.out.println(m1.getName());
		System.out.println(m1.getEmail());
		System.out.println(m1.getPassword());
		System.out.println(m1.getTel());
		this.memberRepository.save(m1);
	}

}
