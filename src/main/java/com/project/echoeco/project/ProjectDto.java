package com.project.echoeco.project;

import javax.validation.constraints.NotBlank;

import javax.validation.constraints.NotNull;

import lombok.Getter;

@Getter
public class ProjectDto {
  @NotBlank(message = "프로젝트  목적을 선택하세요.")
  private String object;

  @NotBlank(message = "프로젝트 명을 입력하세요.")
  private String title;

  @NotBlank(message = "프로젝트의 상세 내용을 입력하세요.")
  private String content;

  @NotNull(message = "목표 금액을 입력하세요")
  private Integer goal;

  private String imgName;

  private String imgUrl;

  private ProjectStatus project_status;

  public Integer getId() {
    return null;
  }

  public Integer getId() {
    return null;
  }
}
