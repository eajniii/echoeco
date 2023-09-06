package com.project.echoeco.board;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BoardController {


	@GetMapping("board")
	public String board() {
		
		return "패트와 매트";
	}
	
}
