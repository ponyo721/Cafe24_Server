package com.cafe24.server.controller;

import com.cafe24.server.domain.user.User;
import com.cafe24.server.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // 회원가입 폼
    @GetMapping("/register")
    public String showRegisterForm() {
        return "register"; // templates/register.html
    }

    // 회원가입 처리
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestParam String username,
                                      @RequestParam String password,
                                      @RequestParam String email) {
        try {
            User savedUser = userService.registerUser(username, password, email);
            return ResponseEntity.ok("회원가입 성공: " + savedUser.getUsername());
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body("회원가입 실패: " + e.getMessage());
        }
    }

    // 로그인 처리
    @PostMapping("/login")
    @ResponseBody
    public String login(@RequestParam String username,
                        @RequestParam String password) {
        boolean success = userService.login(username, password);
        return success ? "로그인 성공" : "로그인 실패";
    }
}