package com.cafe24.server.controller;
import com.cafe24.server.dto.SignupRequest;
import com.cafe24.server.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;

@RestController
@RequestMapping("/api")
public class UserController {
    private final UserService userService;
    final static Logger logger = Logger.getLogger(MainController.class.getName());

    public UserController(UserService userService) {
        logger.info("UserController(UserService userService) called");

        this.userService = userService;
    }

    @PostMapping("/signup")
    public ResponseEntity<String> signup(@Valid @RequestBody SignupRequest request) {
        logger.info("signup called");
        userService.signup(request);
        return ResponseEntity.ok("회원가입 성공!");
    }

    @GetMapping("/users")
    public ResponseEntity<?> getAllUsers() {
        logger.info("getAllUsers called");
        return ResponseEntity.ok(userService.getAllUsers());
    }
}