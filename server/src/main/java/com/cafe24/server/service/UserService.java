package com.cafe24.server.service;
import com.cafe24.server.dto.SignupRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    private final List<SignupRequest> users = new ArrayList<>();

    public void signup(SignupRequest request) {
        users.add(request);
    }

    public List<SignupRequest> getAllUsers() {
        return users;
    }
}