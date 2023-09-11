package com.project.echoeco;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing // jpa auditing 기능 사용 선언
@SpringBootApplication
public class EchoecoApplication {

	public static void main(String[] args) {
		SpringApplication.run(EchoecoApplication.class, args);
	}

}
