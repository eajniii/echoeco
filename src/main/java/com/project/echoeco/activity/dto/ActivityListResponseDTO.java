package com.project.echoeco.activity.dto;

import java.time.format.DateTimeFormatter;

import com.project.echoeco.activity.entity.Activity;

import lombok.Data;

@Data
public class ActivityListResponseDTO {

	public Integer id;
	
	public String object;
	
	public String title;
	
	public String createAt;
	
	public String deadLine;
	
	public String imgUri;
	
	public Integer goalCnt;
	
	public Integer currentCnt;
	
	public void setActivityListDTO(Activity activity) {
		this.id = activity.getId();
		this.createAt = activity.getCreatedAt().format(DateTimeFormatter.ofPattern("yy년 MM월 dd일"));;
		this.object = activity.getObject();
		this.title = activity.getTitle();
//		this.deadLine = activity.getDeadLine().format(DateTimeFormatter.ofPattern("yy년 MM월 dd일 HH:mm:ss"));
		this.goalCnt = activity.getGoalCnt();
		this.currentCnt = activity.getCurruntCnt();
	}
}
