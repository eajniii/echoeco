package com.project.echoeco.activity.dto;

import java.time.LocalDateTime;

import com.project.echoeco.activity.entity.Activity;

import lombok.Data;

@Data
public class ActivityListResponseDTO {

	public Integer id;
	
	public String object;
	
	public String title;
	
	public LocalDateTime createAt;
	
	public LocalDateTime DeadLine;
	
	public String imgUri;
	
	public Integer goalCnt;
	
	public Integer currentCnt;
	
	public void setActivityListDTO(Activity activity) {
		this.id = activity.getId();
		this.createAt = activity.getCreatedAt();
		this.object = activity.getObject();
		this.title = activity.getTitle();
		this.DeadLine = activity.getDeadLine();
		this.goalCnt = activity.getGoalCnt();
		this.currentCnt = activity.getCurruntCnt();
	}
}
