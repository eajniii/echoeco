package com.project.echoeco.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
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
@RequiredArgsConstructor
@EnableWebSecurity
@Component
public class SecurityConfig {

	private final TokenProvider tokenProvider;
	private final JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;
	private final JwtAccessDeniedHandler jwtAccessDeniedHandler;

	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public WebSecurityCustomizer configure() {
		return web -> web.ignoring()
				.antMatchers("/h2-console/**")
				.antMatchers("/static/**")
				.antMatchers("/api/**");
	}

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity)
			throws Exception {
		httpSecurity
				.httpBasic(basic -> basic.disable())
				.csrf(csrf -> csrf.disable())
				.cors().and()
				.sessionManagement(management -> management
						.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
				.exceptionHandling(handling -> handling
						.authenticationEntryPoint(jwtAuthenticationEntryPoint)
						.accessDeniedHandler(jwtAccessDeniedHandler))
				.authorizeRequests(requests -> requests // ????, ??¡Æ¢® ¨ù©ø?¢´
						.antMatchers("/auth/**").permitAll()
						.anyRequest().authenticated())
				.apply(new AuthenticationConfig(tokenProvider));

		return httpSecurity.build();

	}

}
