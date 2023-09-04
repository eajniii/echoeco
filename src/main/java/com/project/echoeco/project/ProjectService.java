package com.project.echoeco.project;

import org.springframework.stereotype.Service;

import com.project.echoeco.controller.ProjectDto;
import com.project.echoeco.domain.Project;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProjectService {
  private final ProjectRepository projectRepository;

  public void create(ProjectDto projectDto) {
    Project project = Project.builder()
        .title(projectDto.getTitle())
        .content(projectDto.getContent())
        .img_url(projectDto.getImg_url())
        .goal(projectDto.getGoal())
        .project_status(projectDto.getProject_status())
        .build();

    projectRepository.save(project);
  }

}
