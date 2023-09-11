package com.project.echoeco.common.exception;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ErrorCode {

  MEMBER_DUPLICATED(HttpStatus.CONFLICT, ""),
  EMAIL_NOT_FOUND(HttpStatus.NOT_FOUND, ""),
  INVALID_PASSWORD(HttpStatus.UNAUTHORIZED, "");

  private HttpStatus httpStatus;
  private String message;
}
