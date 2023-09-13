package com.project.echoeco.config;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import com.project.echoeco.common.exception.AppException;
import com.project.echoeco.common.exception.ErrorCode;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class SecurityUtil {

  public static Long getCurrentMemberId() {
    final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    if (authentication == null || authentication.getName() == null) {
      throw new AppException(ErrorCode.INVALID_ACCESS, "인증 정보가 없습니다.");
    }
    return Long.parseLong(authentication.getName());
  }
}
