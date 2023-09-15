package com.project.echoeco.addrEntity;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.echoeco.activity.entity.State;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/api/city")
public class AddressController {

	private final AddressService addressService;
	
	@GetMapping
	public ResponseEntity<List<StateDTO>> getStateListByCity(@RequestParam("city") String city){
		System.out.println(city);
		List<State> _state= this.addressService.returnstate(city);
		List<StateDTO> dtoList = new ArrayList<>();
		for (State state : _state) {
			StateDTO dto = new StateDTO();
			dto.setState(state.getState());
			dtoList.add(dto);
			System.out.println(state.getState());	
		}
		return ResponseEntity.ok(dtoList);
	}
	
}
