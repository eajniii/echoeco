package com.project.echoeco.activity.dto;

import java.time.LocalDateTime;

import com.project.echoeco.activity.entity.Activity;
import com.project.echoeco.common.constant.ProjectStatus;

import lombok.Data;

@Data
public class ActivityResponseDTO {

	private Integer id;
	
	private LocalDateTime deadLine;
	
	private LocalDateTime createAt;
	
	private LocalDateTime modifiedAt;
	
	private String state;
	
	private String object;
	
	private String title;
	
	private String contents;
	
	private Integer currentCnt;
	
	private ProjectStatus projectStatus;
	
	private String createdBy;
	
	private String modifiedBy;
	
	public void setActivityResponseDTO(Activity activity) {
		this.id = activity.getId();
		this.deadLine = activity.getDeadLine();
		this.createAt = activity.getCreatedAt();
		this.modifiedAt = activity.getModifiedAt();
		this.state = activity.getState().getState();
		this.object = activity.getObject();
		this.title = activity.getTitle();
		this.contents = activity.getContents();
		this.currentCnt = activity.getCurruntCnt();
		this.projectStatus = activity.getProjectStatus();
		this.createdBy = activity.getCreatedBy();
		this.modifiedAt = activity.getModifiedAt();
	}
}
