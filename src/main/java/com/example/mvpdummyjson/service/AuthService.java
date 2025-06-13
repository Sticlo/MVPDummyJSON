package com.example.mvpdummyjson.service;

import com.example.mvpdummyjson.client.DummyJsonClient;
import com.example.mvpdummyjson.dto.LoginRequest;
import com.example.mvpdummyjson.dto.LoginResponse;
import com.example.mvpdummyjson.dto.UserResponse;
import com.example.mvpdummyjson.entity.LoginLog;
import com.example.mvpdummyjson.repository.LoginLogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final DummyJsonClient client;
    private final LoginLogRepository repository;

    public UserResponse loginAndFetchMe(LoginRequest request) {
        LoginResponse response = client.login(request);
        String cookie = String.format("accessToken=%s; refreshToken=%s", response.getAccessToken(), response.getRefreshToken());
        UserResponse me = client.me(cookie);

        LoginLog log = new LoginLog();
        log.setUsername(request.getUsername());
        log.setAccessToken(response.getAccessToken());
        log.setRefreshToken(response.getRefreshToken());
        repository.save(log);

        return me;
    }
}
