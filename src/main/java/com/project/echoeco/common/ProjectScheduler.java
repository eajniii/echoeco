package com.project.echoeco.common;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.project.echoeco.activity.entity.Activity;
import com.project.echoeco.activity.repository.ActivityRepository;
import com.project.echoeco.common.constant.ProjectStatus;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class ProjectScheduler {
	private final ActivityRepository activityRepository;

	@Scheduled(cron = "0 0 0 * * *")
	public void changeProjectOpen() {
		List<Activity> _activity = this.activityRepository.findByProjectStatus(ProjectStatus.ONGOING);
		LocalDateTime currentTime = LocalDateTime.now();
		for(Activity activity : _activity) {
			if(activity.getDeadLine().isAfter(currentTime) || activity.getDeadLine().isEqual(currentTime)) {
				Activity updateActivity = activity.toBuilder().projectStatus(ProjectStatus.CLOSED).build();
				this.activityRepository.save(updateActivity);
			}
		}
	}
}
