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
public class FundingService {
  private final FundingRepository projectRepository;
  public List<Funding> getProjects;

  @Transactional(readOnly = true)
  public List<Funding> getProjects() {

    return projectRepository.findAll();

  }

  public void newProject(FundingDto projectDto, MultipartFile imgFile) throws Exception {
    String oriImgName = imgFile.getOriginalFilename();
    String imgName = "";
    String projectPath = System.getProperty("user.dir") + "/src/main/resources/static/files";

    UUID uudi = UUID.randomUUID();
    String savedFileName = uudi + "_" + oriImgName;
    imgName = savedFileName;

    File saveFiles = new File(projectPath, imgName);
    imgFile.transferTo(saveFiles);

    Funding project = Funding.builder()
        .object(projectDto.getObject())
        .title(projectDto.getTitle())
        .contents(projectDto.getContents())
        .goalAmount(projectDto.getGoalAmount())
        // .imgName(imgName)
        // .imgPath("/files/" + imgName)
        .build();

    projectRepository.save(project);
  }

}
