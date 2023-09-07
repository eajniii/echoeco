package com.project.echoeco.addrEntity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class State {

	private int idx;
	
	private String state;
	
	@ManyToOne
	private City city;
	
	
}
