package com.project.echoeco.addrEntity;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.echoeco.activity.entity.City;
import com.project.echoeco.activity.entity.State;

public interface StateRepository extends JpaRepository<State, Integer> {
	
	Optional<State> findByState(String state);
	
	List<State> findByCity(City city);

}
