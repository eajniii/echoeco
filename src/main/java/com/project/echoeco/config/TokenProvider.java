package com.project.echoeco.config;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class TokenProvider {
  private final JwtFilter jwtFilter;

}
