package com.project.echoeco.activity.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.echoeco.activity.dto.ActivityDTO;
import com.project.echoeco.activity.dto.ActivityListResponseDTO;
import com.project.echoeco.activity.dto.ActivityResponseDTO;
import com.project.echoeco.activity.entity.Activity;
import com.project.echoeco.activity.service.ActivityService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/api/activity")
public class ActivityController {

	private final ActivityService activityService;
	
	
	@GetMapping
	public ResponseEntity<List<ActivityListResponseDTO>> findAllActivity(
			@RequestParam(value = "state",defaultValue = "") String state,
			@RequestParam(value = "keyWord",defaultValue = "") String keyWord
			){
		List<ActivityListResponseDTO> activityListDTO = new ArrayList<ActivityListResponseDTO>();
		try {
			activityListDTO = this.activityService.allActivity(keyWord, state);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.ok(activityListDTO);
	}

	@GetMapping(value = "/{activity_id}")
	public ResponseEntity<Object> findById(@PathVariable("activity_id") Integer idx){
		try {
	        Optional<Activity> _activity = this.activityService.findById(idx);
	        if (_activity.isPresent()) {
	            Activity activity = _activity.get();
	            ActivityResponseDTO activityForm = new ActivityResponseDTO();
	            activityForm.setActivityResponseDTO(activity);
	            return ResponseEntity.ok(activityForm);
	        } else {
	            Map<String, Object> errorResponse = new HashMap<>();
	            errorResponse.put("message", "삭제된 게시물입니다.");
	            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	    }
	}
	
	@GetMapping("/create")
	public ResponseEntity<ActivityDTO> createActivity(){
		ActivityDTO activityDTO = new ActivityDTO();
		return ResponseEntity.ok(activityDTO);
	}
	
	@PutMapping("/create")
	public ResponseEntity<Object> createActivity(@RequestBody ActivityDTO dto, BindingResult bindingResult, Principal principal) {
	
		if(bindingResult.hasErrors()) {
			return ResponseEntity.noContent().build();
		}
		this.activityService.createProject(dto, principal.getName());
		return ResponseEntity.ok("프로젝트 생성을 완료했습니다.");
	}
}
