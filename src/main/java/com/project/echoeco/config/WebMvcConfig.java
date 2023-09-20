package com.project.echoeco.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

	@Value("${uploadPath}")
	String uploadPath;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/echoeco/img/**")		// 서버에서 처리되는 경로
                .addResourceLocations(uploadPath);		//실제 이미지가 저장되는 물리적 경로
    }
}
