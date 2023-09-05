package com.project.echoeco.project;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

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
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  private String object;

  private String title;

  @Lob
  private String content;

  private Integer goal;

  private String imgName;

  private String imgPath;

  @Enumerated(EnumType.STRING)
  private ProjectStatus project_status;

  @Builder
  public Project(String object, String title, String content, Integer goal,
      String imgName, String imgPath,
      ProjectStatus project_status) {
    this.object = object;
    this.title = title;
    this.content = content;
    this.goal = goal;
    this.imgName = imgName;
    this.imgPath = imgPath;
    this.project_status = project_status;
  }

}
