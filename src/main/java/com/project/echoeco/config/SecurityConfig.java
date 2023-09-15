package com.project.echoeco.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.stereotype.Component;

import com.project.echoeco.config.Token.AuthenticationConfig;
import com.project.echoeco.config.Token.JwtAccessDeniedHandler;
import com.project.echoeco.config.Token.JwtAuthenticationEntryPoint;
import com.project.echoeco.config.Token.TokenProvider;

import lombok.RequiredArgsConstructor;

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
