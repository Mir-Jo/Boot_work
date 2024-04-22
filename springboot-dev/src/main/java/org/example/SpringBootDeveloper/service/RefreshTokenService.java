package org.example.SpringBootDeveloper.service;

import lombok.RequiredArgsConstructor;
import org.example.SpringBootDeveloper.domain.RefreshToken;
import org.example.SpringBootDeveloper.repository.RefreshTokenRepository;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class RefreshTokenService {
    private final RefreshTokenRepository refreshTokenRepository;

    public RefreshToken findByRefreshToken(String refreshToken){
        return refreshTokenRepository.findByRefreshToken(refreshToken)
                .orElseThrow(() -> new IllegalArgumentException("Unexcepted token"));
    }
}
