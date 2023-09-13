package com.project.echoeco.activity.controller;

import org.springframework.web.bind.annotation.RestController;

import com.project.echoeco.activity.service.ActivityService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class ActivityController {

	private final ActivityService activityService;
	
}
