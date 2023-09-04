package com.project.echoeco.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Project {
  @Id
  @Column(name = "project_id")
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;

  private String title;

  private String content;

  private String img_url;

  private Integer goal;

  @Enumerated(EnumType.STRING)
  private ProjectStatus project_status;

  @Builder
  public Project(String title, String content, String img_url, Integer goal, ProjectStatus project_status) {
    this.title = title;
    this.content = content;
    this.img_url = img_url;
    this.goal = goal;
    this.project_status = project_status;
  }

}
