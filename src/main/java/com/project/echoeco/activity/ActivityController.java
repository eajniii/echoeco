package com.project.echoeco.activity;

import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class ActivityController {

	private final ActivityService activityService;
	
}
