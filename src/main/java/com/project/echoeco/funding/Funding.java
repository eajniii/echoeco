package com.project.echoeco.funding;

import java.math.BigDecimal;

import javax.persistence.Entity;

import com.project.echoeco.common.BaseProject;
import com.project.echoeco.projectImg.entity.FundingImg;

import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Entity
@SuperBuilder
@Getter
@ToString
public class Funding extends BaseProject {

  private BigDecimal goalAmount;

  private BigDecimal currentAmount;

  // @OneToMany(cascade = CascadeType.ALL)
  // @JoinColumn(name = "projectImgId")
  // private List<ProjectImg> fundingImg;

}
