package com.metropolitan.it355.services;

import com.metropolitan.it355.entity.User;

import java.util.Optional;

public interface UserService {
    Optional<User> getUserByUsername(String username);
}
