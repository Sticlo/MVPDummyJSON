package com.example.mvpdummyjson;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class MvpDummyJsonApplication {
    public static void main(String[] args) {
        SpringApplication.run(MvpDummyJsonApplication.class, args);
    }
}
