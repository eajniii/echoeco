package com.project.echoeco.project;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/project")
public class ProjectController {

	private final ProjectService projectService;

	// 리스트 전체 조회
	@GetMapping("/list")
	public String projectList(Model model) {
		List<Project> projectList = projectService.getProjects();
		model.addAttribute("list", projectList);
		return "projectList";
	}

	@GetMapping("/create")
	public String createProject() {
		return "projectForm";
	}

	@PostMapping("/create")
	public void saveProject(ProjectDto projectDto) {
		projectService.create(projectDto);

	}

}
