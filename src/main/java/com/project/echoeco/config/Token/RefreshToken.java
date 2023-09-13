package com.project.echoeco.config.Token;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class RefreshToken {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", updatable = false)
  private Integer id;

  @Column(name = "memberId", nullable = false, unique = true)
  private Integer memberId;

  @Column(name = "refreshToken", nullable = false)
  private String refreshToken;

  public RefreshToken(Integer memberId, String refreshToken) {
    this.memberId = memberId;
    this.refreshToken = refreshToken;
  }

  public RefreshToken update(String newRefreshToken) {
    this.refreshToken = newRefreshToken;
    return this;
  }

}
