package com.metropolitan.it355.services.impl;

import com.metropolitan.it355.entity.User;
import com.metropolitan.it355.repository.UserRepository;
import com.metropolitan.it355.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    final UserRepository userRepository;

    @Override
    public Optional<User> getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
