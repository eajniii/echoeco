package com.project.echoeco.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.header.writers.frameoptions.XFrameOptionsHeaderWriter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
public class SecurityConfig {


	SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
		http
			.authorizeHttpRequests((authorizehttpRequests) -> authorizehttpRequests
				.requestMatchers(new AntPathRequestMatcher("/**")).permitAll())
			.csrf((csrf) -> csrf
					.ignoringRequestMatchers(new AntPathRequestMatcher("/h2-console/**")))
			.headers((headers) -> headers
					.addHeaderWriter(new XFrameOptionsHeaderWriter(
							XFrameOptionsHeaderWriter.XFrameOptionsMode.SAMEORIGIN)))
			//스프링시큐리티의 로그인 부분 담당
			.formLogin((formLogin) -> formLogin
			.loginPage("/member/login")
			.defaultSuccessUrl("/project/list"))
			;
		return http.build();
			
	}
	//BCrypt 해싱함수로 패스워드 암호화
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();

		public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
		return httpSecurity
				.httpBasic().disable()
				.csrf().disable()
				.cors().and()
				.authorizeRequests()
				.antMatchers("/**").permitAll()
				.antMatchers("/members/join", "/members/login").permitAll()
				.and()
				.sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
				.and()
				.build();

		}
	// @Bean
	// SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
	// http
	// .authorizeHttpRequests((authorizehttpRequests) -> authorizehttpRequests
	// .requestMatchers(new AntPathRequestMatcher("/**")).permitAll())
	// .csrf((csrf) -> csrf
	// .ignoringRequestMatchers(new AntPathRequestMatcher("/h2-console/**")))
	// .headers((headers) -> headers
	// .addHeaderWriter(new XFrameOptionsHeaderWriter(
	// XFrameOptionsHeaderWriter.XFrameOptionsMode.SAMEORIGIN)))
	// ;
	// return http.build();

	// }

}
