package com.project.echoeco.activity.entity;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.project.echoeco.common.BaseProject;
import com.project.echoeco.projectImg.ProjectImg;

import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Entity
@SuperBuilder
@Getter
@ToString
public class Activity extends BaseProject {

	private Integer goalCnt;

	private LocalDateTime deadLine;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "projectImgId")
	private List<ProjectImg> activityImg;

	@OneToOne(cascade = CascadeType.ALL)
	private Activity_State activityState;

}
