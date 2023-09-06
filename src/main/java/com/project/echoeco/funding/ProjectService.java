package com.project.echoeco.funding;

import java.io.File;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

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

  public void newProject(ProjectDto projectDto, MultipartFile imgFile) throws Exception {
    String oriImgName = imgFile.getOriginalFilename();
    String imgName = "";
    String projectPath = System.getProperty("user.dir") + "/src/main/resources/static/files";

    UUID uudi = UUID.randomUUID();
    String savedFileName = uudi + "_" + oriImgName;
    imgName = savedFileName;

    File saveFiles = new File(projectPath, imgName);
    imgFile.transferTo(saveFiles);

    Project project = Project.builder()
        .object(projectDto.getObject())
        .title(projectDto.getTitle())
        .contents(projectDto.getContents())
        .goal(projectDto.getGoal())
        .imgName(imgName)
        .imgPath("/files/" + imgName)
        .project_status(projectDto.getProject_status())
        .build();

    projectRepository.save(project);
  }

}
