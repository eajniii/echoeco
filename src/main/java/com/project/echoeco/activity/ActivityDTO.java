package com.project.echoeco.activity;

import java.io.File;
import java.time.LocalDateTime;
import java.util.List;

import lombok.Data;

@Data
public class ActivityDTO {
	private String object;
	
	private String title;
	
	private String content;
	
	private Integer goalCnt;
	
	private String state;
	
	private LocalDateTime deadLine;
	
	private List<File> activityImg;
}
