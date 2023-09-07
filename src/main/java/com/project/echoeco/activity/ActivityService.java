package com.project.echoeco.activity;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ActivityService {

	private final ActivityRepository activityRepository;
	
	public List<Activity> allActivity(){
		
		return this.activityRepository.findAll();
	}
	public Optional<Activity> currentActivity(Integer idx){
		
		return this.activityRepository.findById(idx);
	}
	
	public void participate(Long activity_idx,Long member_idx) {
	
		Optional<Activity> _activity = this.activityRepository.findById(activity_idx);
		if(!_activity.isEmpty()) {
			Activity activity = _activity.get();
			
		}
	}
	
}
