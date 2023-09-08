package com.project.echoeco.activity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.echoeco.activity.entity.Activity_State;

@Repository
public interface AddressRepository extends JpaRepository<Activity_State, Integer> {

	
}
