package com.project.echoeco.activity.entity;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.project.echoeco.common.BaseProject;
import com.project.echoeco.projectImg.entity.ActivityImg;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Entity
@SuperBuilder(toBuilder = true)
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor

public class Activity extends BaseProject {

	private Integer goalCnt;

	private LocalDateTime deadLine;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "projectImgId")
	private List<ActivityImg> activityImg;

	@ManyToOne
	@JoinColumn(name = "state_id")
	private State state;

}
