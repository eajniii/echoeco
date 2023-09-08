package com.project.echoeco.activity;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.project.echoeco.common.constant.ProjectStatus;
import com.project.echoeco.member.Member;
import com.project.echoeco.member.MemberRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ActivityService {

	private final ActivityRepository activityRepository;
	private final MemberRepository memberRepository;
	private final ATVT_ParticipantsRepository participateRepository;

	public List<Activity> allActivity() {

		return this.activityRepository.findAll();
	}
	public Optional<Activity> findById(Integer id){
		return this.activityRepository.findById(id);
	}
	
	//프로젝트 생성하기
	public void createProject(ActivityDTO dto, String email) {
		Activity activity  = Activity.builder()
				.contents(dto.getContent())
				.createdDate(LocalDateTime.now())
				.goalCnt(dto.getGoalCnt())
				.object(dto.getObject())
				.project_status(ProjectStatus.ONGOING)
				.createdEmail(email)
				.deadLine(dto.getDeadLine())
				.build();
		this.activityRepository.save(activity);
	}
	
	//신청하기
	public void participate(Integer activity_idx, Integer member_idx) throws Exception {

		Optional<Activity> _activity = this.activityRepository.findById(activity_idx);
		Optional<Member> _member = this.memberRepository.findById(member_idx);
		if (!_activity.isEmpty()&&!_member.isEmpty()) {
			Activity activity = _activity.get();
			Member member = _member.get();
			if(activity.getCurruntCnt() > activity.getGoalCnt()) {
				activity.builder().project_status(ProjectStatus.CLOSED).build();
				this.activityRepository.save(activity);
				throw new Exception("정원 초과 하였습니다.");
				
			}else {
				Activity_Member participate= Activity_Member
						.builder()
						.activity(activity)
						.member(member)
						.build();
				this.participateRepository.save(participate);	
			}
		}else {
			throw new Exception("다시 시도해 주세요");
		}
	}

}
