package com.project.echoeco.addrEntity;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.echoeco.activity.entity.State;

public interface StateRepository extends JpaRepository<State, Integer> {
	
	State findByState(String state);

}
