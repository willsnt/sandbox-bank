package com.sandboxbank.model.account;

import javax.money.MonetaryAmount;
import java.time.LocalDateTime;

public class Account {

    private Long accountID;
    private Long accountNumber;
    private AccountType type;
    private AccountStatus status;

    private String pinHash;

    private MonetaryAmount balance;

    private LocalDateTime lastAccess;
    private int pinAttempts;
    private LocalDateTime lastPinAttempt;
    private LocalDateTime lockedUntil;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    private final Long clientID;

    public Account(AccountType type, String pinHash, Long clientID) {

        this.type = type;
        this.pinHash = pinHash;
        this.clientID = clientID;
    }

    public Account(Long accountID, Long accountNumber, AccountType type, AccountStatus status, LocalDateTime lastAccess, String pinHash, int pinAttempts, LocalDateTime lastPinAttempt, MonetaryAmount balance, LocalDateTime lockedUntil, LocalDateTime createdAt, LocalDateTime updatedAt, Long clientID) {

        this.accountID = accountID;
        this.accountNumber = accountNumber;
        this.type = type;
        this.status = status;
        this.lastAccess = lastAccess;
        this.pinHash = pinHash;
        this.pinAttempts = pinAttempts;
        this.lastPinAttempt = lastPinAttempt;
        this.balance = balance;
        this.lockedUntil = lockedUntil;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.clientID = clientID;
    }

    public Long getAccountID() {

        return accountID;
    }

    public Long getAccountNumber() {

        return accountNumber;
    }

    public AccountType getType() {

        return type;
    }

    public AccountStatus getStatus() {

        return status;
    }

    public LocalDateTime getLastAccess() {

        return lastAccess;
    }

    public String getPinHash() {

        return pinHash;
    }

    public int getPinAttempts() {

        return pinAttempts;
    }

    public LocalDateTime getLastPinAttempt() {

        return lastPinAttempt;
    }

    public MonetaryAmount getBalance() {

        return balance;
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
