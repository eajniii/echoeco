package com.project.echoeco.activity;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.project.echoeco.addrEntity.State;
import com.project.echoeco.baseEntity.BaseProject;

import lombok.Data;

@Entity
@Data
public class Activity extends BaseProject{
	
	
	//이 프로젝트가 진행되는 위치(ex)고양시, 파주시, 안양시,광주시
	//하나의 프로젝트에서 여러개의 위치를 갖을수 없게끔 manytomany 사용
	@ManyToMany
	private Set<State> state;
	
	private Integer maxint;
	
	private Integer currentint;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<ActivityImg> activityImg;
	
	//현제 신청한 인원 manytomany 사용 여러명의 사용자가 하나의 Activity에
	//신청할수 있지만 중복해서 신청은 불가 manytomany는 서로의 연관성을 pk로 사용
	
}
