package com.sandboxbank.model.account;


import org.javamoney.moneta.Money;
import org.javamoney.moneta.format.CurrencyStyle;

import javax.money.MonetaryAmount;
import javax.money.format.AmountFormatQueryBuilder;
import javax.money.format.MonetaryAmountFormat;
import javax.money.format.MonetaryFormats;
import java.time.LocalDateTime;
import java.util.Locale;

public class Account {

    private Long accountID;
    private Long accountNumber;
    private AccountType type;
    private AccountStatus status;
    private String pinHash;

    private MonetaryAmount balance;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Account(AccountType type, String pinHash) {

        this.type = type;
        this.status = AccountStatus.ACTIVE;
        this.pinHash = pinHash;
        this.balance = Money.of(0, "USD");
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }


    public Account(Long accountID, Long accountNumber, AccountType type, AccountStatus status, String pinHash, MonetaryAmount balance, LocalDateTime createdAt, LocalDateTime updatedAt) {

        this.accountID = accountID;
        this.accountNumber = accountNumber;
        this.type = type;
        this.status = status;
        this.pinHash = pinHash;
        this.balance = balance;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Long getAccountID() {

        return accountID;
    }

    public void setAccountID(Long accountID) {

        this.accountID = accountID;
    }

    public Long getAccountNumber() {

        return accountNumber;
    }

    public void setAccountNumber(Long accountNumber) {

        this.accountNumber = accountNumber;
    }

    public AccountType getType() {

        return type;
    }

    public void setType(AccountType type) {

        this.type = type;
    }

    public AccountStatus getStatus() {

        return status;
    }

    public void setStatus(AccountStatus status) {

        this.status = status;
    }

    public String getPinHash() {

        return pinHash;
    }

    public void setPinHash(String pinHash) {

        this.pinHash = pinHash;
    }

    public MonetaryAmount getBalance() {

        return balance;
    }

    public void setBalance(MonetaryAmount balance) {

        this.balance = balance;
    }

    public String getBalanceFormatted() {

        MonetaryAmountFormat formatter = MonetaryFormats.getAmountFormat(
                AmountFormatQueryBuilder.of(Locale.US)
                        .set(CurrencyStyle.SYMBOL)
                        .build()
        );

        return formatter.format(balance);
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
