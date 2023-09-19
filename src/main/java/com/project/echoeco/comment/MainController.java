package com.project.echoeco.comment;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.echoeco.member.auth.MemberRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@CrossOrigin(originPatterns = "http:localhost:3000")
@RequiredArgsConstructor
public class MainController {

}
