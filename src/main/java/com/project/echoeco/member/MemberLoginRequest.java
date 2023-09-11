package com.project.echoeco.member;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class MemberLoginRequest {

  private String email;
  private String password;
}
