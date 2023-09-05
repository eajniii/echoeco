package com.project.echoeco;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.project.echoeco.member.Member;
import com.project.echoeco.member.MemberRepository;

@SpringBootTest
class EchoecoApplicationTests {

	@Autowired
	private MemberRepository memberRepository;
	
	@Test
	void testJpa() {
		Member m1 = new Member();
		m1.setEmail("123@123.com");
		m1.setName("패트");
		m1.setPassword("1234");
	}

}
