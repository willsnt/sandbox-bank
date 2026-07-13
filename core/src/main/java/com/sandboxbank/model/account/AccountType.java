package com.sandboxbank.model.account;

public enum AccountType {

    CHECKING("Checking"),
    SAVINGS("Savings");

    private final String displayName;

    AccountType(String displayName) {

        this.displayName = displayName;
    }

    public String getDisplayName() {

        return displayName;
    }
}
