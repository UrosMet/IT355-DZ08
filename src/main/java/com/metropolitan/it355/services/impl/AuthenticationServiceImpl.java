package com.metropolitan.it355.services.impl;

import com.metropolitan.it355.dto.LoginResponse;
import com.metropolitan.it355.dto.UserDTO;
import com.metropolitan.it355.entity.User;
import com.metropolitan.it355.jwt.JwtService;
import com.metropolitan.it355.repository.UserRepository;
import com.metropolitan.it355.services.AuthenticationService;
import com.metropolitan.it355.services.TokenBlackListService;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@AllArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {

    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final TokenBlackListService tokenBlackListService;


    @Override
    public LoginResponse login(UserDTO authenticationRequest) {
        UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                authenticationRequest.getUsername(), authenticationRequest.getPassword()
        );
        authenticationManager.authenticate(authToken);
        User user = userRepository.findByUsername(authenticationRequest.getUsername()).get();
        String jwt = jwtService.generateToken(user, generateExtraClaims(user));
        return new LoginResponse(jwt);
    }

    @Override
    public Map<String, Object> generateExtraClaims(User user) {
        Map<String, Object> extraClaims = new HashMap<>();
        extraClaims.put("ID" , user.getId());
        extraClaims.put("Username" , user.getUsername());
        return extraClaims;
    }

    @Override
    public void logout(String token) {
        tokenBlackListService.blacklistToken(token);
        SecurityContextHolder.clearContext();
    }
}
