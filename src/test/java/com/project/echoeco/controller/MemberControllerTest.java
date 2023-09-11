package com.project.echoeco.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithAnonymousUser;
import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.echoeco.common.exception.AppException;
import com.project.echoeco.common.exception.ErrorCode;
import com.project.echoeco.member.MemberController;
import com.project.echoeco.member.MemberJoinRequest;
import com.project.echoeco.member.MemberLoginRequest;
import com.project.echoeco.member.MemberService;

@WebMvcTest
@AutoConfigureMockMvc
public class MemberControllerTest {
  @Autowired
  MockMvc mockMvc;

  @InjectMocks
  private MemberController memberController;
  @MockBean
  private MemberService memberService;

  @Autowired
  private ObjectMapper objectmapper = new ObjectMapper();

  @Test
  @DisplayName("회원가입 성공")
  void join() throws Exception {
    String email = "aa@ccc.dd";
    String password = "3241KJ!d";
    String name = "하이";

    mockMvc.perform(MockMvcRequestBuilders.post("/members/join")
        .with(SecurityMockMvcRequestPostProcessors.csrf())
        .contentType(MediaType.APPLICATION_JSON)
        .content(objectmapper.writeValueAsBytes(new MemberJoinRequest(email, password, name))))
        .andDo(MockMvcResultHandlers.print())
        .andExpect(MockMvcResultMatchers.status().isOk());
  }

  @Test
  @DisplayName("회원가입 실패!")
  public void join_fail() throws Exception {
    String email = "aa@ccc.dd";
    String password = "3241KJ!d";
    String name = "인재";
    Integer tel = 3902211;

    mockMvc.perform(MockMvcRequestBuilders.post("/members/join")
        .with(SecurityMockMvcRequestPostProcessors.csrf())
        .contentType(MediaType.APPLICATION_JSON)
        .content(objectmapper.writeValueAsBytes(new MemberLoginRequest(email, password))))
        .andDo(MockMvcResultHandlers.print())
        .andExpect(MockMvcResultMatchers.status().isConflict());

  }

  @Test
  @DisplayName("로그인 성공")
  public void login_success() throws Exception {
    String email = "ewof@iwwd.co";
    String password = "wkeo@22";
    when(memberService.login(any(), any()))
        .thenReturn("token");

    mockMvc.perform(MockMvcRequestBuilders.post("/members/login")
        .with(SecurityMockMvcRequestPostProcessors.csrf())
        .contentType(MediaType.APPLICATION_JSON)
        .content(objectmapper.writeValueAsBytes(new MemberLoginRequest(email, password))))
        .andDo(MockMvcResultHandlers.print()).andExpect(MockMvcResultMatchers.status().isOk());
  }

  @Test
  @DisplayName("로그인 실패 - email 오류")
  @WithAnonymousUser
  public void login_fail1() throws Exception {
    String email = "ewof@iwwd.co";
    String password = "wkeo@22";
    when(memberService.login(any(), any()))
        .thenThrow(new AppException(ErrorCode.EMAIL_NOT_FOUND, ""));

    mockMvc.perform(MockMvcRequestBuilders.post("/members/login")
        .with(SecurityMockMvcRequestPostProcessors.csrf())
        .contentType(MediaType.APPLICATION_JSON)
        .content(objectmapper.writeValueAsBytes(new MemberLoginRequest(email, password))))
        .andDo(MockMvcResultHandlers.print())
        .andExpect(MockMvcResultMatchers.status().isNotFound());
  }

  @Test
  @DisplayName("로그인 성공 - pw 오류 ")
  public void login_fail2() throws Exception {
    String email = "ewof@iwwd.co";
    String password = "wkeo@22";
    when(memberService.login(any(), any()))
        .thenThrow(new AppException(ErrorCode.EMAIL_NOT_FOUND, ""));

    mockMvc.perform(MockMvcRequestBuilders.post("/members/login")
        .with(SecurityMockMvcRequestPostProcessors.csrf())
        .contentType(MediaType.APPLICATION_JSON)
        .content(objectmapper.writeValueAsBytes(new MemberLoginRequest(email, password))))
        .andDo(MockMvcResultHandlers.print())
        .andExpect(MockMvcResultMatchers.status().isUnauthorized());
  }
}