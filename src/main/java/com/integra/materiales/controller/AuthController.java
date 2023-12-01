package com.integra.materiales.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.integra.materiales.dto.AuthDto;
import com.integra.materiales.services.TokenService;

@RestController
public class AuthController {
    
    private static final Logger LOG = LoggerFactory.getLogger(AuthController.class);

    private final TokenService tokenService;

    public AuthController(TokenService tokenService) {
        this.tokenService = tokenService;
    }

    @PostMapping("/api/v1/token")
    public AuthDto token(Authentication authentication){
        LOG.debug("Token requested for user '{}'", authentication.getName());
        return tokenService.generateTokens(authentication);
    }

}
