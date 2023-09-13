package com.project.echoeco;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.web.WebAppConfiguration;

import com.project.echoeco.activity.entity.Activity;
import com.project.echoeco.activity.repository.ActivityRepository;
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

	@Test
	void testActivity() {
		Activity atv;
		atv = Activity.builder()
				.contents("안녕하세요")
				.curruntCnt(0)
				.goalCnt(5).projectStatus(ProjectStatus.ONGOING)
				.createdAt(LocalDateTime.now())
				.createdBy("ltk2956")
				.build();
		atvtRepository.save(atv);
	}

}
