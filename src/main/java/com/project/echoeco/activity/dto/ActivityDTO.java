package com.project.echoeco.activity.dto;

import java.io.File;
import java.time.LocalDateTime;
import java.util.List;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class ActivityDTO {
	
	@NotBlank(message = "제목은 필수 입력란입니다.")
	private String object;
	
	@NotBlank(message = "제목은 필수 입력란입니다.")
	private String title;
	
	@NotBlank(message = "세부내용은 필수 입력란입니다.")
	private String content;
	
	@NotBlank(message = "목표인원은 필수 입력란입니다.")
	private Integer goalCnt;
	
	@NotBlank(message = "지역은 필수 입력란입니다.")
	private String state;
	
	@NotBlank(message = "마감일은 필수 입력란입니다.")
	private LocalDateTime deadLine;
	
	private List<File> activityImg;
}
