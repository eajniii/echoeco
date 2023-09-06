package com.project.echoeco.baseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.MappedSuperclass;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.project.echoeco.project.ProjectStatus;

@Entity
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseProject {
	
	  @Id
	  @Column(name = "project_id")
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	  private Integer id;

	  private String object;

	  private String title;

	  @Lob
	  private String contents;
	  
	  //Acti
	  private Integer goal;
	  
	  @Enumerated(EnumType.STRING)
	  private ProjectStatus project_status;
	  
	  
}
