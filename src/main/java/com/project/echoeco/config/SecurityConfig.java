package com.project.echoeco.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

	@Bean
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
