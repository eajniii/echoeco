package com.project.echoeco.addrEntity;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.echoeco.activity.entity.City;

public interface CityRepository extends JpaRepository<City, Integer> {

	Optional<City> findByCity(String city);
}
