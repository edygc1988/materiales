package com.integra.materiales.services;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.stream.Collectors;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.stereotype.Service;

import com.integra.materiales.dto.AuthDto;

@Service
public class TokenService {
    private final JwtEncoder encoder;

    public TokenService(JwtEncoder encoder) {
        this.encoder = encoder;
    }
    
    public AuthDto generateTokens(Authentication authentication) {
        Instant now = Instant.now();
        
        // Genera un access token
        String accessToken = generateToken(authentication, now, now.plus(1, ChronoUnit.HOURS));

        // Genera un refresh token válido por más tiempo
        String refreshToken = generateToken(authentication, now, now.plus(1, ChronoUnit.HOURS));

        return new AuthDto(accessToken, refreshToken, now.plus(1, ChronoUnit.HOURS).toString());
    }

    public String generateToken(Authentication authentication, Instant issuedAt, Instant expiresAt) {
        Instant now = Instant.now();
        String scope = authentication.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.joining(" "));
        JwtClaimsSet claimsSet = JwtClaimsSet.builder()
                .issuer("self")
                .issuedAt(issuedAt)
                .expiresAt(now.plus(1, ChronoUnit.HOURS))
                .subject(authentication.getName())
                .claim("scope", scope)
                .build();
        return this.encoder.encode(JwtEncoderParameters.from(claimsSet)).getTokenValue();

    }
}
