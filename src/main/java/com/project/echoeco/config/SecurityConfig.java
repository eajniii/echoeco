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

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public WebSecurityCustomizer configure() {
		return web -> web.ignoring()
				.antMatchers("/h2-console")
				.antMatchers("/static/**")
				.antMatchers("/api/**");

	}

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity)
			throws Exception {
		httpSecurity
				.httpBasic(basic -> basic.disable())
				.csrf(csrf -> csrf.disable())
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
// httpSecurity
// .httpBasic().disable()
// .csrf().disable() // csrf 허용 안함
// .cors() // cross origin 허용

// .and()
// .sessionManagement()
// .sessionCreationPolicy(SessionCreationPolicy.STATELESS) // jwt 사용 시 설정

// .and()
// .exceptionHandling()
// .authenticationEntryPoint(jwtAuthenticationEntryPoint)
// .accessDeniedHandler(jwtAccessDeniedHandler)

// .and()
// .authorizeRequests() // 인증, 인가 설정
// .antMatchers("/login", "/signup", "/members/**", "/auth/**").permitAll()
// .and().formLogin()
// // 폼 기반 로그인 설정
// .loginPage("/login").defaultSuccessUrl("/") // 로그인 성공시
// .and().logout().logoutSuccessUrl("/").invalidateHttpSession(true) // 로그아웃 이후
// 전체 삭제 여부
// .and()
// .apply(new AuthenticationConfig(tokenProvider));

// return httpSecurity.build();

// }