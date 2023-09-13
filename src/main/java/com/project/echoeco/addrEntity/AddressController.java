package com.project.echoeco.addrEntity;

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
@RequestMapping("/api")
public class AddressController {

	private final AddressService addressService;
	
	@GetMapping("/city")
	public ResponseEntity<String> getStateListByCity(@RequestParam("city") String city){
		System.out.println(city);
//		List<State> state = this.addressService.returnstate(city);
//		for (State _state: state) {
//			System.out.print(_state.getState()+" ");
//		}
		
		return ResponseEntity.ok().body("처리되었습니다.");
	}
	
}
