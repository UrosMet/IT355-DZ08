package com.metropolitan.it355.security;

import com.metropolitan.it355.jwt.filter.JwtFilter;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;

import java.util.List;

@Configuration
@EnableWebSecurity
@AllArgsConstructor
public class WebSecurityConfig {

    private AuthenticationProvider authenticationProvider;
    private JwtFilter jwtAuthenticationFilter;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
                .csrf(AbstractHttpConfigurer::disable)
                .sessionManagement(sessionMangConfig -> sessionMangConfig.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authenticationProvider(authenticationProvider)
                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
                .authorizeHttpRequests( authConfig -> authConfig
                        .requestMatchers(HttpMethod.POST, "/auth/login").permitAll()
                        .requestMatchers("/error").permitAll()
                        .requestMatchers("/admin/**").hasAuthority("FULL_ACCESS")
                        .requestMatchers("/city/**").hasAnyAuthority("FULL_ACCESS","READ_ONLY")
                        .requestMatchers("/medal/**").hasAnyAuthority("FULL_ACCESS","READ_ONLY")
                        .requestMatchers("/nocRegion/**").hasAnyAuthority("FULL_ACCESS","READ_ONLY")
                        .requestMatchers("/sport/**").hasAnyAuthority("FULL_ACCESS","READ_ONLY")
                        .anyRequest().authenticated()
                );

        return http.build();

    }
}
