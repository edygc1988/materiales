package com.integra.materiales.config;

import static org.springframework.security.config.Customizer.withDefaults;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.oauth2.server.resource.OAuth2ResourceServerConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import com.nimbusds.jose.jwk.JWK;
import com.nimbusds.jose.jwk.JWKSet;
import com.nimbusds.jose.jwk.RSAKey;
import com.nimbusds.jose.jwk.source.ImmutableJWKSet;
import com.nimbusds.jose.jwk.source.JWKSource;
import com.nimbusds.jose.proc.SecurityContext;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

        private final RsaKeyProperties rsaKeysKeyProperties;

        public SecurityConfig(RsaKeyProperties rsaKeyProperties) {
                this.rsaKeysKeyProperties = rsaKeyProperties;
        }

        @Bean
        public InMemoryUserDetailsManager user(PasswordEncoder passwordEncoder) {
                return new InMemoryUserDetailsManager(
                                User.withUsername("user_api")
                                                .password(passwordEncoder.encode("Clv_Enc_2023"))
                                                .authorities("read")
                                                .roles("USER")
                                                .build());
        }

        @Bean
        public PasswordEncoder passwordEncoder() {
                return new BCryptPasswordEncoder();
        }

        @Bean
        public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
                return httpSecurity
                                //.cors(cors -> cors.configurationSource(corsConfigurationSource()))
                                .csrf(csrf -> csrf.disable())
                                .authorizeHttpRequests(auth -> auth.anyRequest().authenticated())
                                .oauth2ResourceServer(OAuth2ResourceServerConfigurer::jwt)
                                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                                .httpBasic(withDefaults())
                                .build();

        }

        @Bean
        CorsConfigurationSource corsConfigurationSource() {
                CorsConfiguration configuration = new CorsConfiguration();
                configuration.setAllowedOrigins(Arrays.asList("*"));
                configuration.setAllowedMethods(Arrays.asList("OPTIONS","GET","POST","UPDATE"));
                configuration.setAllowedHeaders(List.of("Authorization"));
                UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
                source.registerCorsConfiguration("/**", configuration);
                return source;
        }
        

        @Bean
        JwtDecoder jwtDecoder() {
                return NimbusJwtDecoder.withPublicKey(rsaKeysKeyProperties.publicKey()).build();
        }

        @Bean
        JwtEncoder jwtEncoder() {
                JWK jwk = new RSAKey.Builder(rsaKeysKeyProperties.publicKey())
                                .privateKey(rsaKeysKeyProperties.privateKey()).build();
                JWKSource<SecurityContext> jwkSource = new ImmutableJWKSet<>(new JWKSet(jwk));
                return new NimbusJwtEncoder(jwkSource);
        }
}
