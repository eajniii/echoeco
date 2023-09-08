package com.project.echoeco;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.web.WebAppConfiguration;

import com.project.echoeco.activity.Activity;
import com.project.echoeco.activity.ActivityRepository;
import com.project.echoeco.addrEntity.City;
import com.project.echoeco.addrEntity.CityRepository;
import com.project.echoeco.common.constant.ProjectStatus;
import com.project.echoeco.common.constant.Role;
import com.project.echoeco.member.Member;
import com.project.echoeco.member.MemberRepository;

@SpringBootTest
@WebAppConfiguration
class EchoecoApplicationTests {

	@Autowired
	private MemberRepository memberRepository;
	@Autowired
	private ActivityRepository atvtRepository;
	@Autowired
	private CityRepository cityRepository;

	@Test
	void testJpa() {
		Member m1 = Member.builder()
				.email("123@123.com")
				.name("패트")
				.password("1234")
				.role(Role.ADMIN)
				.createdDate(LocalDateTime.now())
				.tel(12345678)
				.build();

		this.memberRepository.save(m1);

	}

	@Test
	void testActivity() {
		Activity atv;
		atv = Activity.builder()
				.contents("안녕하세요")
				.curruntCnt(0)
				.goalCnt(5).project_status(ProjectStatus.ONGOING)
				.createdDate(LocalDateTime.now())
				.createdEmail("ltk2956")
				.build();
		System.out.println("들어간 값 확인 : " + atv.getContents());
		System.out.println("들어간 값 확인 : " + atv.getCreatedEmail());
		System.out.println("들어간 값 확인 : " + atv.getCurruntCnt());
		atvtRepository.save(atv);
	}
	
}
