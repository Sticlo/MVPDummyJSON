package com.example.mvpdummyjson.client;

import com.example.mvpdummyjson.dto.LoginRequest;
import com.example.mvpdummyjson.dto.LoginResponse;
import com.example.mvpdummyjson.dto.UserResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "dummyJson", url = "https://dummyjson.com")
public interface DummyJsonClient {

    @PostMapping(value = "/auth/login", consumes = MediaType.APPLICATION_JSON_VALUE)
    LoginResponse login(@RequestBody LoginRequest request);

    @GetMapping(value = "/auth/me")
    UserResponse me(@RequestHeader("Cookie") String cookie);
}
