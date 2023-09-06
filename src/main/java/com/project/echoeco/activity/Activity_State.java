package com.project.echoeco.activity;

import java.lang.reflect.Member;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Activity_State {
	
	@OneToOne
	private Member member;
	
	@ManyToOne
	private List<Activity> activity;
}
