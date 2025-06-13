package com.example.mvpdummyjson.repository;

import com.example.mvpdummyjson.entity.LoginLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginLogRepository extends JpaRepository<LoginLog, Long> {
}
