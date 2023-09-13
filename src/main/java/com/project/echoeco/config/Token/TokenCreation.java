package com.project.echoeco.config.Token;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TokenCreation {

  private String grantType;
  private String accessToken;
  private Long tokenExpiresIn;
}
