package com.sandboxbank.model.user;

import java.time.LocalDateTime;

public class User {

    private Long userID;
    private String username;
    private String passwordHash;
    private UserStatus status;

    private LocalDateTime lastLogin;
    private int loginAttempts;
    private LocalDateTime lockedUntil;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public User(String username, String passwordHash) {

        this.username = username;
        this.passwordHash = passwordHash;
        this.status = UserStatus.ACTIVE;
        this.lastLogin = null;
        this.loginAttempts = 0;
        this.lockedUntil = null;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    public User(Long userID, String username, String passwordHash, UserStatus status, LocalDateTime lastLogin, int loginAttempts, LocalDateTime lockedUntil, LocalDateTime createdAt, LocalDateTime updatedAt) {

        this.userID = userID;
        this.username = username;
        this.passwordHash = passwordHash;
        this.status = status;
        this.lastLogin = lastLogin;
        this.loginAttempts = loginAttempts;
        this.lockedUntil = lockedUntil;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Long getUserID() {

        return userID;
    }

    public void setUserID(Long userID) {

        this.userID = userID;
    }

    public String getUsername() {

        return username;
    }

    public void setUsername(String username) {

        this.username = username;
    }

    public String getPasswordHash() {

        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {

        this.passwordHash = passwordHash;
    }

    public UserStatus getStatus() {

        return status;
    }

    public void setStatus(UserStatus status) {

        this.status = status;
    }

    public LocalDateTime getLastLogin() {

        return lastLogin;
    }

    public void setLastLogin(LocalDateTime lastLogin) {

        this.lastLogin = lastLogin;
    }

    public int getLoginAttempts() {

        return loginAttempts;
    }

    public void setLoginAttempts(int loginAttempts) {

        this.loginAttempts = loginAttempts;
    }

    public LocalDateTime getLockedUntil() {

        return lockedUntil;
    }

    public void setLockedUntil(LocalDateTime lockedUntil) {

        this.lockedUntil = lockedUntil;
    }

    public LocalDateTime getCreatedAt() {

        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {

        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {

        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {

        this.updatedAt = updatedAt;
    }
}
