package com.cafe24.server.service;

import com.cafe24.server.domain.user.User;
import com.cafe24.server.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@Transactional
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // 회원가입
    public User register(String username, String email, String rawPassword) {
        String hashed = passwordEncoder.encode(rawPassword);

        User user = new User();
        user.setUsername(username);
        user.setEmail(email);
        user.setPasswordHash(hashed);

        return userRepository.save(user);
    }

    // 로그인
    public boolean login(String username, String rawPassword) {
        return userRepository.findByUsername(username).map(user -> {
            if (user.isLocked()) {
                return false; // 잠긴 계정
            }
            boolean matches = passwordEncoder.matches(rawPassword, user.getPasswordHash());

            if (matches) {
                user.setFailedAttempts(0);
                user.setLastLoginAt(LocalDateTime.now());
                return true;
            } else {
                user.setFailedAttempts(user.getFailedAttempts() + 1);
                if (user.getFailedAttempts() >= 5) { // 실패 5회 → 잠금
                    user.setLocked(true);
                }
                return false;
            }
        }).orElse(false);
    }
}

