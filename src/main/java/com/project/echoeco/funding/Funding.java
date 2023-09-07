package com.project.echoeco.funding;

import java.math.BigDecimal;

import javax.persistence.Entity;

import com.project.echoeco.common.BaseProject;

import groovy.transform.ToString;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Entity
@SuperBuilder
@Getter
@ToString
public class Funding extends BaseProject {

  private BigDecimal goalAmount;

  private BigDecimal currentAmount;

}
