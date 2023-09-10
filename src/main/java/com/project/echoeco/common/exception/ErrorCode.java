package com.project.echoeco.common.exception;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ErrorCode {

  MEMBER_DUPLICATED(HttpStatus.CONFLICT, "");

  private HttpStatus httpStatus;
  private String message;
}
