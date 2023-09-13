package com.project.echoeco.comment;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
  @GetMapping("/")
  @ResponseBody
  public String main() {
    return "안녕하세요";
  }
}
