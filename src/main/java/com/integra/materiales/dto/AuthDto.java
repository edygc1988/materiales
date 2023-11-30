package com.integra.materiales.dto;

public class AuthDto {
    
    private final String accessToken;
    private final String refreshToken;
    private final String expiresAt;

    public AuthDto(String accessToken, String refreshToken, String expiresAt) {
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
        this.expiresAt = expiresAt;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public String getExpiresAt() {
        return expiresAt;
    }
}