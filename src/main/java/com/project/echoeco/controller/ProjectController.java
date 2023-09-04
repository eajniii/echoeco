package com.project.echoeco.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProjectController {

	@GetMapping("/projects")
	public String projectList() {
		return "index";
	}

}
