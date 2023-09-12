package com.project.echoeco.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.web.SecurityFilterChain;

import com.project.echoeco.member.auth.AuthService;

import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class SecurityConfig {

	private final AuthService authService;

	@Bean
	public WebSecurityCustomizer configure() {
		return web -> web.ignoring()
				.antMatchers("/h2-console")
				.antMatchers("/static/**");

	}

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity)
			throws Exception {
		return httpSecurity
				.httpBasic().disable()
				.csrf().disable() // csrf 허용 안함
				.cors().and() // cross origin 허용
				.authorizeRequests() // 인증, 인가 설정
				.antMatchers("/login", "/signup", "/members/**").permitAll().and().formLogin()
				// 폼 기반 로그인 설정
				.loginPage("/login").defaultSuccessUrl("/") // 로그인 성공시
				.and().logout().logoutSuccessUrl("/").invalidateHttpSession(true) // 로그아웃 이후 전체 삭제 여부
				.and().build();
		// .sessionManagement()
		// .sessionCreationPolicy(SessionCreationPolicy.STATELESS)

	}

}

// }.httpBasic(basic->basic.disable
// .csrf().disable() // csrf 허용 안함
// .cors().and() // cross origin 허용
// .authorizeRequests() // 인증, 인가 설정
// .antMatchers("/login","/signup","/members/**").permitAll().and().formLogin()
// // 폼 기반 로그인 설정
// .loginPage("/login").defaultSuccessUrl("/") // 로그인 성공시
// .and().logout().logoutSuccessUrl("/").invalidateHttpSession(true) // 로그아웃 이후
// 전체 삭제 여부
// .and().build();
