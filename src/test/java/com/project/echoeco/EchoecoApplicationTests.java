package com.project.echoeco;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.web.WebAppConfiguration;

import com.project.echoeco.activity.entity.Activity;
import com.project.echoeco.activity.entity.State;
import com.project.echoeco.activity.repository.ActivityRepository;
import com.project.echoeco.addrEntity.CityRepository;
import com.project.echoeco.addrEntity.StateRepository;
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
	@Autowired
	private StateRepository stateRepository;
//
//	@Test
//	void testJpa() {
//		Member m1 = Member.builder()
//				.email("dew23@weie.com")
//				.password("1234")
//				.role(Role.ADMIN)
//				.tel(12345678)
//				.createdAt(LocalDateTime.now())
//				.build();
//
//		this.memberRepository.save(m1);
//
//	}
//
//	@Test
//	void testActivity() {
//		Activity atv;
//		atv = Activity.builder()
//				.contents("안녕하세요")
//				.curruntCnt(0)
//				.goalCnt(5).projectStatus(ProjectStatus.ONGOING)
//				.createdAt(LocalDateTime.now())
//				.createdBy("ltk2956")
//				.build();
//
//		atvtRepository.save(atv);
//	}
//
//	@Test
//	void testCityAndState() {
//		String[] cityList={"서울","경기","인천","강원","충북","충남","대전","전북","전남","경북","경남","제주"};
//
//		String[][] stateList = {
//		    { "강남구", "강동구", "강북구", "강서구", "관악구", "광진구", "구로구", "금천구", "노원구", "도봉구", "동대문구", "동작구", "마포구", "서대문구", "서초구", "성동구", "성북구", "송파구", "양천구", "영등포구", "용산구", "은평구", "종로구", "중구", "중랑구"},
//		    { "고양시", "과천시", "광명시", "광주시", "구리시", "군포시", "김포시", "남양주시", "동두천시", "부천시", "성남시", "수원시", "시흥시", "안산시", "안성시", "안양시", "양주시", "양평군", "여주시", "연천군", "오산시", "용인시", "의왕시", "의정부시", "이천시", "파주시", "평택시", "포천시", "하남시", "화성시"},
//		    { "강화군", "계양구", "남동구", "동구", "미추홀구", "부평구", "서구", "연수구", "옹진군", "중구"},
//		    { "강릉시", "고성군", "동해시", "삼척시", "속초시", "양구군", "양양군", "영월군", "원주시", "인제군", "정선군", "철원군", "춘천시", "태백시", "평창군", "홍천군", "화천군", "횡성군"},
//		    { "청주시", "충주시", "제천시", "보은군", "영동군", "옥천군", "음성군", "진천군", "괴산군", "단양군"},
//		    { "대전시", "서산시", "논산시", "계룡시", "공주시", "금산군", "논산시", "당진시", "보령시", "부여군", "서천군", "아산시", "예산군", "천안시", "홍성군"},
//		    { "대전시"},
//		    { "전주시", "군산시", "익산시", "정읍시", "남원시", "김제시", "완주군", "진안군", "무주군", "장수군", "임실군", "순창군", "고창군", "부안군"},
//		    { "목포시", "여수시", "순천시", "나주시", "광양시", "담양군", "곡성군", "구례군", "무안군", "보성군", "신안군", "여수시", "영광군", "영암군", "완도군", "장성군", "장흥군", "진도군", "함평군", "해남군", "화순군"},
//		    { "대구시", "포항시", "경주시", "안동시", "구미시", "영주시", "영천시", "상주시", "문경시", "경산시", "김천시", "칠곡군", "고령군", "성주군", "영덕군", "청도군", "청송군", "예천군"},
//		    { "부산시", "창원시", "진주시", "양산시", "거제시", "통영시", "김해시", "밀양시", "사천시", "김해시", "밀양시", "사천시", "거창군", "고성군", "남해군", "산청군", "양산시", "의령군", "함안군", "함양군", "합천군"},
//		    { "제주시", "서귀포시"}};
//		for (int i = 0; i<cityList.length; i++) {
//			City city = City.builder().city(cityList[i]).build();
//			this.cityRepository.save(city);
//			for(int j = 0; j<stateList[i].length; j++) {
//				State state = State.builder().state(stateList[i][j]).city(city).build();
//				this.stateRepository.save(state);
//			}
//		}
//	}
	@Test
	void getStateAndCity() {
//		List<City> city = this.cityRepository.findAll();
//		for(City _city : city) {
//			System.out.println(_city.getCity());
//		}
	}
	@Test
	void insertActivity() {
//		Optional<State> state = this.stateRepository.findByState("고양시");
//		for(int i = 0; i<100; i++) {
//			Activity activity = Activity.builder().createdAt(LocalDateTime.now()).contents("내용1").title("제목 "+i).createdBy("ltk2956").goalCnt(5).curruntCnt(0).state(state.get()).build();
//			this.atvtRepository.save(activity);
//		}
//		Optional<Activity> _activity1 = atvtRepository.findById(11);
//		Activity at = _activity1.get();
//		System.out.println(at.getContents()+at.getTitle());
//		Activity modifyAt = at.toBuilder().contents("수정된 내용1").modifiedAt(LocalDateTime.now()).title("수정됐지롱1").build();
//		System.out.println(modifyAt.getContents()+modifyAt.getTitle());
//		this.atvtRepository.save(modifyAt);
		Optional<State> state = this.stateRepository.findByState("고양시");
		List<Activity> _activity = this.atvtRepository.findAllActivitiesWithKeywordAndState("수정", state.get());
		for(Activity activity: _activity) {
			System.out.println(activity.getContents()+activity.getId());
		}
	}
}
