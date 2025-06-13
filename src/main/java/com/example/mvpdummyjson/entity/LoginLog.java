package com.example.mvpdummyjson.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.Instant;

@Data
@Entity
@Table(name = "login_log")
public class LoginLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    @CreationTimestamp
    @Column(name = "login_time", updatable = false)
    private Instant loginTime;

    @Column(name = "access_token", length = 512)
    private String accessToken;

    @Column(name = "refresh_token", length = 512)
    private String refreshToken;
}
