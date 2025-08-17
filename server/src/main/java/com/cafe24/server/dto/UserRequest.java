package com.cafe24.server.dto;

public class UserRequest {
    private String username;
    private String email;
    private String passwordHash;

    public String getUsername() { return username; }
    public String getEmail() { return email; }
    public String getPasswordHash() { return passwordHash; }
}