package com.project.echoeco.member.auth;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PasswordChangeRequest {
  private String email;
  private String exPassword;
  private String newPassword;
}
