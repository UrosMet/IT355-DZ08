package com.metropolitan.it355.services;

public interface TokenBlackListService {
    void blacklistToken(String token);
    boolean isTokenBlacklisted(String token);
}
