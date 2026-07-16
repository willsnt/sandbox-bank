package com.sandboxbank.model.account;

public enum AccountStatus {

    ACTIVE("Active"),
    LOCKED("Locked"),
    CLOSED("Closed");

    private final String displayName;

    AccountStatus(String displayName) {

        this.displayName = displayName;
    }

    public String getDisplayName() {

        return displayName;
    }
}
