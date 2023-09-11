//package com.project.echoeco.controller;
//
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
//import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.project.echoeco.member.MemberDTO;
//import com.project.echoeco.member.MemberJoinRequest;
//import com.project.echoeco.member.MemberService;
//
//@WebMvcTest
//@AutoConfigureMockMvc
//public class MemberControllerTest {
//  @Autowired
//  MockMvc mockMvc;
//
//  @MockBean
//  MemberService memberService;
//
//  @Autowired
//  ObjectMapper objectmapper;
//
//  @Test
//  @DisplayName("회원가입 완료!")
//  public void join() throws Exception {
//    String email = "aa@ccc.dd";
//    String password = "3241KJ!d";
//    String name = "Jane";
//
//    mockMvc.perform(post("/members/join")
//        .contentType(MediaType.APPLICATION_JSON)
//        .content(objectmapper.writeValueAsBytes(new MemberJoinRequest(email, password, name))))
//        .andDo(MockMvcResultHandlers.print())
//        .andExpect(MockMvcResultMatchers.status().isOk());
//
//  }
//
//  @Test
//  @DisplayName("회원가입 실패!")
//  public void join_fail() throws Exception {
//    String email = "aa@ccc.dd";
//    String name = "Jane";
//    String password = "3241KJ!d";
//    Integer tel = 1425323;
//
//    mockMvc.perform(MockMvcRequestBuilders.post("/members/join")
//        .contentType(MediaType.APPLICATION_JSON)
//        .content(objectmapper.writeValueAsBytes(new MemberDTO(email, name, password, tel))))
//        .andDo(MockMvcResultHandlers.print())
//        .andExpect(MockMvcResultMatchers.status().isConflict());
//
//  }
//
//  @Test
//  @DisplayName("로그인 성공")
//  public void login_success() throws Exception {
//
//  }
//
//  @Test
//  @DisplayName("로그인 실패 - email 오류")
//  public void login_fail1() throws Exception {
//
//  }
//
//  @Test
//  @DisplayName("로그인 성공 - pw 오류 ")
//  public void login_fail2() throws Exception {
//
//  }
//}