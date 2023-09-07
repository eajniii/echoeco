package com.project.echoeco.baseEntity;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class Base {

	@CreatedBy
	private String createdEmail;
	
	@LastModifiedBy
	private String modifiedEmail;
	
}
