package com.project.echoeco.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class EncoderConfig {
  @Bean
  public BCryptPasswordEncoder encoder() { // 순환 참조가 발생할 수 있어 security config와 반드시 다른 파일로 생성

    return new BCryptPasswordEncoder();
  }
}
