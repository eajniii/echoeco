package com.project.echoeco.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.project.echoeco.member.MemberService;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {
	private final MemberService memberService;
	@Value("{jwt.secret}")
	private String secretKey;

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
		return httpSecurity
				.httpBasic().disable() // ui가 아닌 토큰 인증으로 수행
				.csrf().disable()
				.cors().and()
				.authorizeRequests()
				.antMatchers("/**").permitAll()
				.antMatchers("/members/join", "/members/login").permitAll()
				.antMatchers(HttpMethod.POST, "/board/write").authenticated()
				.and()
				.sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
				.and()
				.addFilterBefore(new JwtFilter(memberService, secretKey), UsernamePasswordAuthenticationFilter.class)
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
