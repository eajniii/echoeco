package com.project.echoeco.common;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.MappedSuperclass;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.project.echoeco.common.constant.ProjectStatus;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@SuperBuilder
@Getter
public abstract class BaseProject extends BaseMember {

	@Id
	@Column(name = "project_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String object;

	private String title;

	@Lob
	private String contents;

	private Integer curruntCnt;

	@Enumerated(EnumType.STRING)
	private ProjectStatus project_status;

}
