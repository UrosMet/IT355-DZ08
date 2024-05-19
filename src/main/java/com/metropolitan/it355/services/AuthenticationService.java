package com.metropolitan.it355.services;

import com.metropolitan.it355.dto.LoginResponse;
import com.metropolitan.it355.dto.UserDTO;
import com.metropolitan.it355.entity.User;

import java.util.Map;

public interface AuthenticationService {
    LoginResponse login(UserDTO authenticationRequest);
    Map<String, Object> generateExtraClaims(User user);
    void logout(String token);
}
