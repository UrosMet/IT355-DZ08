package com.metropolitan.it355.controller;

import com.metropolitan.it355.dto.LoginResponse;
import com.metropolitan.it355.dto.UserDTO;
import com.metropolitan.it355.services.AuthenticationService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/auth")
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> loginResponseResponseEntity(@RequestBody UserDTO userDTO){
        return ResponseEntity.ok(authenticationService.login(userDTO));
    }
}
