package com.project.echoeco.member;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class MemberJoinRequest {
  String email;
  String password;
  String name;
}
