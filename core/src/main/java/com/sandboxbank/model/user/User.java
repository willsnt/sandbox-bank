package com.sandboxbank.model.user;

import java.time.LocalDateTime;

public class User {

    private Long userID;
    private final String username;
    private String passwordHash;
    private UserStatus status;

    private LocalDateTime lastLogin;
    private int loginAttempts;
    private LocalDateTime lockedUntil;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    private final Long clientID;

    public User(String username, String passwordHash, Long clientID) {

        this.username = username;
        this.passwordHash = passwordHash;
        this.clientID = clientID;
    }

    public User(Long userID, String username, String passwordHash, UserStatus status, LocalDateTime lastLogin, int loginAttempts, LocalDateTime lockedUntil, LocalDateTime createdAt, LocalDateTime updatedAt, Long clientID) {

        this.userID = userID;
        this.username = username;
        this.passwordHash = passwordHash;
        this.status = status;
        this.lastLogin = lastLogin;
        this.loginAttempts = loginAttempts;
        this.lockedUntil = lockedUntil;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.clientID = clientID;
    }

    public Long getUserID() {

        return userID;
    }

    public String getUsername() {

        return username;
    }

    public String getPasswordHash() {

        return passwordHash;
    }

    public UserStatus getStatus() {

        return status;
    }

    public LocalDateTime getLastLogin() {

        return lastLogin;
    }

    public int getLoginAttempts() {

        return loginAttempts;
    }

    public LocalDateTime getLockedUntil() {

        return lockedUntil;
    }

    public LocalDateTime getCreatedAt() {

        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {

        return updatedAt;
    }

    public Long getClientID() {

        return clientID;
    }
}
