package com.project.echoeco.contentImg;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.project.echoeco.project.Project;

@Entity
public class contentImg {
  @Id
  @Column(name = "img_id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  private String imgName;

  private String imgUrl;

  private String mainImg;

  @ManyToOne(fetch = FetchType.LAZY)
  private Project project_id;

  public void updateImg(String imgName, String imgUrl) {
    this.imgName = imgName;
    this.imgUrl = imgUrl;
  }
}
