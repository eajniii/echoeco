package com.project.echoeco.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.project.echoeco.project.ProjectService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class ProjectController {

	private final ProjectService projectService;

	@GetMapping("/projects")
	public String projectList() {
		return "projectList";
	}

	@PostMapping("/projects")
	public String createProject(ProjectDto projectDto) {
		projectService.create(projectDto);
		return "redirect:index";
	}

}
