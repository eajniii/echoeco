package com.project.echoeco.project;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class ProjectService {
  private final ProjectRepository projectRepository;
  public List<Project> getProjects;

  @Transactional(readOnly = true)
  public List<Project> getProjects() {

    return projectRepository.findAll();

  }

  public void create(ProjectDto projectDto) {
    Project project = Project.builder()
        .title(projectDto.getTitle())
        .content(projectDto.getContent())
        .goal(projectDto.getGoal())
        .imgName(projectDto.getImgName())
        .imgPath(projectDto.getImgUrl())
        .project_status(projectDto.getProject_status())
        .build();

    projectRepository.save(project);
  }

}
