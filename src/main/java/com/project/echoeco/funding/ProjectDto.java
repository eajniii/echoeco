package com.project.echoeco.funding;

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
  private String contents;

  @NotNull(message = "목표 금액을 입력하세요")
  private Integer goal;

  private ProjectStatus project_status;

}
