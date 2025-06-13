package com.example.mvpdummyjson.controller;

import com.example.mvpdummyjson.dto.LoginRequest;
import com.example.mvpdummyjson.dto.UserResponse;
import com.example.mvpdummyjson.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService service;

    @PostMapping("/login")
    public ResponseEntity<UserResponse> login(@RequestBody LoginRequest request) {
        UserResponse response = service.loginAndFetchMe(request);
        return ResponseEntity.ok(response);
    }
}
