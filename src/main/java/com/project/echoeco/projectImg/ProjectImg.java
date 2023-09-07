package com.project.echoeco.projectImg;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Entity
@Getter
public class ProjectImg {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "projectImg_id")
	private Long idx;

	// 대표이미지 설정
	private char YorN;

	private String img;
}
