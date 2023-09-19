package com.project.echoeco.addrEntity;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.project.echoeco.activity.entity.City;
import com.project.echoeco.activity.entity.State;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AddressService {
	
	private final CityRepository cityRepository;
	private final StateRepository stateRepsotiory;

	public List<State> returnstate(String cityName) {
		Optional<City> _city = this.cityRepository.findByCity(cityName);
		
		List<State> state = this.stateRepsotiory.findByCity(_city.get());
		return state;
	}
	

}
