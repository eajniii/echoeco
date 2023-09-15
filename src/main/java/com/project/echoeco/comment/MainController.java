package com.project.echoeco.comment;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(originPatterns = "http:localhost:3000")
public class MainController {
  @GetMapping("/api/hello")
  public String main() {
    return "안녕하세요";
  }
}
