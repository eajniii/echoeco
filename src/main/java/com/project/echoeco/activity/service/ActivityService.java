package com.project.echoeco.activity.service;

import java.nio.file.AccessDeniedException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.project.echoeco.activity.dto.ActivityDTO;
import com.project.echoeco.activity.entity.Activity;
import com.project.echoeco.activity.entity.Activity_Member;
import com.project.echoeco.activity.entity.Activity_State;
import com.project.echoeco.activity.entity.State;
import com.project.echoeco.activity.repository.ATVT_ParticipantsRepository;
import com.project.echoeco.activity.repository.ActivityRepository;
import com.project.echoeco.activity.repository.AddressRepository;
import com.project.echoeco.addrEntity.StateRepository;
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
	private final StateRepository stateRepository;
	private final AddressRepository addrRespository;

	public Page<Activity> allActivity( String keyWord, Integer pageNum, String stateName) {
		List<Sort.Order> sort = new ArrayList();
		sort.add(Sort.Order.desc("createAt"));
		Pageable pageable = PageRequest.of(pageNum,10, Sort.by(sort));
		if(stateName.equals("All")) {
			return this.activityRepository.findAllActivityWithKeyWord(keyWord, pageable);
		}else {
			Optional<State> state = this.stateRepository.findByState(stateName);
			return this.activityRepository.findAllActivitiesWithKeywordAndState(keyWord, state.get(), pageable);
						
		}
	}

	public Optional<Activity> findById(Integer id) throws Exception {
		Optional<Activity> activity = this.activityRepository.findById(id);
		if (!activity.isEmpty()) {
			return this.activityRepository.findById(id);
		} else {
			throw new NullPointerException("현제 삭제된 페이지 입니다.");
		}
	}
	// 프로젝트 수정하기
	public void modifyProject(ActivityDTO dto, Integer idx, String email) throws Exception {
		Optional<Activity> _activity = this.activityRepository.findById(idx);
		if (!_activity.isEmpty()) {
			Activity activity = _activity.get();
			if (email.equals(activity.getCreatedBy())) {
				Activity.builder()
						.modifiedAt(LocalDateTime.now())
						.modifiedBy(email)
						.deadLine(dto.getDeadLine())
						.title(dto.getTitle())
						.contents(dto.getContent())
						.build();
			} else {
				throw new AccessDeniedException("접근권한이 없습니다.");
			}
		}
	}

	// 프로젝트 생성하기
	public void createProject(ActivityDTO dto, String email) {
		Activity activity = Activity.builder()
				.contents(dto.getContent())
				.createdAt(LocalDateTime.now())
				.goalCnt(dto.getGoalCnt())
				.object(dto.getObject())
				.projectStatus(ProjectStatus.ONGOING)
				.createdBy(email)
				.deadLine(dto.getDeadLine())
				.build();
		this.activityRepository.save(activity);
		
		Optional<State> state = this.stateRepository.findByState(dto.getState());
		Activity_State as = Activity_State.builder().activity(activity).state(state.get()).build();
		this.addrRespository.save(as);
	}

	// 신청하기
	public void participate(Integer activity_idx, Long member_idx) throws Exception {

		Optional<Activity> _activity = this.activityRepository.findById(activity_idx);
		Optional<Member> _member = this.memberRepository.findById(member_idx);
		if (!_activity.isEmpty() && !_member.isEmpty()) {
			Activity activity = _activity.get();
			Member member = _member.get();
			if (activity.getCurruntCnt() >= activity.getGoalCnt()) {
				activity.builder().projectStatus(ProjectStatus.CLOSED).build();
				this.activityRepository.save(activity);
				throw new Exception("정원 초과 하였습니다.");

			} else {
				Activity_Member participate = Activity_Member
						.builder()
						.activity(activity)
						.member(member)
						.build();
				this.participateRepository.save(participate);
				
				activity.builder().curruntCnt(activity.getCurruntCnt()+1);
				this.activityRepository.save(activity);
			}
		} else {
			throw new Exception("다시 시도해 주세요");
		}
	}

	// 삭제하기
	public void deleteActivity(String email, Integer activity_idx) {

	}

}
