package com.metropolitan.it355.services.impl;

import com.metropolitan.it355.services.TokenBlackListService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

@Service
@AllArgsConstructor
public class TokenBlackListServiceImpl implements TokenBlackListService {

    private final Set<String> blacklist = ConcurrentHashMap.newKeySet();

    @Override
    public void blacklistToken(String token) {
        System.err.println("Blacklisted token : " + token);
        blacklist.add(token);
    }

    @Override
    public boolean isTokenBlacklisted(String token) {
        return blacklist.contains(token);
    }
}
