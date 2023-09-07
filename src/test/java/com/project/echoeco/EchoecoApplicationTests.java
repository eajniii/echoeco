package com.project.echoeco;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.web.WebAppConfiguration;

import com.project.echoeco.common.constant.Role;
import com.project.echoeco.member.Member;
import com.project.echoeco.member.MemberRepository;

@SpringBootTest
@WebAppConfiguration
@Transactional
class EchoecoApplicationTests {

	@Autowired
	private MemberRepository memberRepository;

	@Test
	void testJpa() {
		Member m1 = Member.builder()
				.email("123@123.com")
				.name("패트")
				.password("1234")
				.role(Role.ADMIN)
				.tel(12345678)
				.build();

		this.memberRepository.save(m1);
	}

}
