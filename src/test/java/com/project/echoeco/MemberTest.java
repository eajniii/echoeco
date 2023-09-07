//package com.project.echoeco;
//
//import org.junit.Test;
//import org.junit.jupiter.api.AfterAll;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeAll;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.DisplayName;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import com.project.echoeco.common.constant.Role;
//import com.project.echoeco.member.Member;
//
//import lombok.Builder;
//
//@SpringBootTest
//@Builder
//public class MemberTest {
//
////	@Autowired
////	private MemberRepository memberRepository;
//	
//	@Test
//	@DisplayName("멤버 생성되는지 테스트")
//	void testMember() {
//		Member mem = Member.builder()
//				.name("피카츄")
//				.email("123@456.com")
//				.password("1234")
//				.tel(12345678)
//				.role(Role.MEMBER)
//				.build();
//		
//		System.out.println(mem.getName());
//		System.out.println(mem.getEmail());
//		System.out.println(mem.getPassword());
//		System.out.println(mem.getTel());
//		System.out.println(mem.getRole());
////		this.memberRepository.save(mem);
//	}
////	    @BeforeAll
////	    static void beforeAll() {
////	        System.out.println("## BeforeAll Annotation 호출 ##");
////	        System.out.println();
////	    }
////
////	    @AfterAll
////	    static void afterAll() {
////	        System.out.println("## afterAll Annotation 호출 ##");
////	        System.out.println();
////	    }
////
////	    @BeforeEach
////	    void beforeEach() {
////	        System.out.println("## beforeEach Annotation 호출 ##");
////	        System.out.println();
////	    }
////
////	    @AfterEach
////	    void afterEach() {
////	        System.out.println("## afterEach Annotation 호출 ##");
////	        System.out.println();
////	    }
////
////	    @Test
////	    void test1() {
////	        System.out.println("## test1 시작 ##");
////	        System.out.println();
////	    }
////
////	    @Test
////	    @DisplayName("Test Case 2!!!")
////	    void test2() {
////	        System.out.println("## test2 시작 ##");
////	        System.out.println();
////	    }
//	
//}
