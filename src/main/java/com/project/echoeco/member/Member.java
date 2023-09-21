package com.project.echoeco.member;

import java.util.Collection;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.project.echoeco.common.BaseTime;
import com.project.echoeco.common.constant.Role;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Entity
@SuperBuilder
@ToString
@Getter
@Table(name = "member")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Member extends BaseTime implements UserDetails {

	@Id
	@Column(name = "memberId")
	@GeneratedValue(strategy = GenerationType.IDENTITY) // 기본 키 설정
	private Long id;

	@Column(unique = true)
	private String email;

	private String password;

	@Column(unique = true)
	private String nickname;

	@Enumerated(EnumType.STRING) // DB에 저장될 때 문자로 저장되게 함
	private Role role;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// 권한 반환
		return List.of(new SimpleGrantedAuthority(role.toString()));
	}

	@Override
	public String getUsername() {
		return email;
	}

	@Override
	public boolean isAccountNonExpired() {
		// 계정 만료 확인
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// 계정 잠금 확인
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// 패스워드 만료 확인
		return true;
	}

	@Override
	public boolean isEnabled() {
		// 계정 사용 가능 여부
		return true;
	}

	// 닉네임 변경
	public void modifyNickname(String nickname) {
		this.nickname = nickname;
	}

	// 비밀번호 변경
	public void modifyPassword(String password) {
		this.password = password;
	}

}
