package com.project.echoeco.common.exception;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ErrorCode {

  ID_NOT_FOUND(HttpStatus.NOT_FOUND,"존재하지 않는 ID입니다. 다시 시도해 주세요"),
  DATA_NOT_FOUND(HttpStatus.NOT_FOUND,"요청하신 데이터가 존재하지 않습니다. 다시 시도해 주세요"),
  MEMBER_DUPLICATED(HttpStatus.CONFLICT, "중복된 아이디가 존재합니다. 다시 시도해 주세요."),
  EMAIL_NOT_FOUND(HttpStatus.NOT_FOUND, "존재하지 않는 이메일입니다. 다시 시도해 주세요."),
  INVALID_PASSWORD(HttpStatus.UNAUTHORIZED, "잘못된 패스워드입니다. 다시 시도해 주세요."),
  EXPIRED_TOKEN(HttpStatus.UNAUTHORIZED, "만료된 토큰입니다. 다시 시도해 주세요."),
  INVALID_ACCESS(HttpStatus.UNAUTHORIZED, "잘못된 접근입니다. 다시 시도해 주세요."),
  UNKNOWN_MEMBER(HttpStatus.REQUESTED_RANGE_NOT_SATISFIABLE, "로그인 유저 정보가 없습니다. 다시 로그인해 주세요.");

  private HttpStatus httpStatus;
  private String message;
}