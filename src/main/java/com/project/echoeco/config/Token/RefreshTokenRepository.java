package com.project.echoeco.config.Token;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RefreshTokenRepository extends JpaRepository<RefreshToken, Integer> {
  Optional<RefreshToken> findByMemberId(Integer memberId);

  Optional<RefreshToken> findByRefreshToken(String refreshToken);
}
