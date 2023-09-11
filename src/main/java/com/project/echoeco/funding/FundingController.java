package com.project.echoeco.funding;

import java.util.List;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import lombok.RequiredArgsConstructor;

@RestController
@CrossOrigin("http://localhost:3000")
@RequiredArgsConstructor
@RequestMapping("/project/funding")
public class FundingController {

  private final FundingService projectService;

  // 리스트 전체 조회
  @GetMapping("/list")
  public String projectList(Model model) {
    List<Funding> projectList = projectService.getProjects();
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
  public String saveProject(FundingDto projectDto, MultipartFile imgFile) throws Exception {
    projectService.newProject(projectDto, imgFile);
    return "redirect:/project/list";
  }

}
