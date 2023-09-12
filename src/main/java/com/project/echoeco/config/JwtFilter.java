package com.project.echoeco.config;

import java.io.IOException;
import java.util.List;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.validator.internal.util.logging.Log;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import com.project.echoeco.member.MemberService;
import com.project.echoeco.utils.JwtUtil;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Slf4j
public class JwtFilter extends OncePerRequestFilter {
  // authorization 헤더값에 담긴 토큰 유효성 확인

  private final TokenProvider tokenProvider;
  private final static String HEADER_AUTHORIZATION = "Authorization";
  private final static String TOKEN_PREFIX = "Bearer";

  private final MemberService memberService;
  private final String secretKey;

  @Override
  protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
      throws ServletException, IOException {

    final String authorization = request.getHeader(HttpHeaders.AUTHORIZATION);

    log.info("authorization : {}", authorization);
    // token 없으면 block
    if (authorization == null || authorization.startsWith("Bearer")) {

      log.error("인가되지 않았습니다.");

      filterChain.doFilter(request, response);
      return;
    }

    // Token 꺼내기
    String token = authorization.split(" ")[1];

    // Token 만료 여부 확인
    if (JwtUtil.isExpired(token, secretKey)) {
      log.error("Token이 만료되었습니다.");
      filterChain.doFilter(request, response);
      return;
    }
    // Token에서 email정보 꺼내기
    String email = JwtUtil.getEmail(token, secretKey);
    log.info("email:{}", email);
    // 권한 부여
    UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(email, null,
        List.of(new SimpleGrantedAuthority("MEMBER")));

    // details
    authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

    SecurityContextHolder.getContext().setAuthentication(authenticationToken);
    filterChain.doFilter(request, response);

  }

}
