package com.project.echoeco.project;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

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
		model.addAttribute("projectList", projectList);
		return "projectList";
	}

	// 프로젝트 생성 페이지
	@GetMapping("/create")
	public String createProject() {
		return "projectForm";
	}

	// 프로젝트 저장
	@PostMapping("/create")
	public String saveProject(ProjectDto projectDto, MultipartFile imgFile) throws Exception {
		projectService.newProject(projectDto, imgFile);
		return "redirect:/project/list";
	}

}
