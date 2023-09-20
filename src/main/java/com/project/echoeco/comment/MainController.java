package com.project.echoeco.comment;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@CrossOrigin(originPatterns = "http:localhost:3000")
@RequiredArgsConstructor
public class MainController {

}
