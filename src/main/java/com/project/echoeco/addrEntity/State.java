package com.project.echoeco.addrEntity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Data;

@Entity
@Data
public class State {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idx;
	
	private String state;
	
	@ManyToOne
	private City city;
	
	
}
