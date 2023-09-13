package com.project.echoeco.member.auth;

import java.util.Collections;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.project.echoeco.member.Member;
import com.project.echoeco.member.MemberRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {
  private MemberRepository memberRepository;

  @Override
  public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
    return memberRepository.findByEmail(email).map(this::createUserDetails)
        .orElseThrow(() -> new UsernameNotFoundException(email + "에 해당하는 회원을 찾을 수 없습니다."));
  }

  private UserDetails createUserDetails(Member member) {
    GrantedAuthority GrantedAuthority = new SimpleGrantedAuthority(member.getRole().toString());

    return new User(String.valueOf(member.getId()),
        member.getPassword(),
        Collections.singleton(GrantedAuthority));
  }
}
