package com.project.echoeco.addrEntity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class City {

	private int idx;
	
	private String City;
	
	@OneToMany
	private List<State> states;
}
