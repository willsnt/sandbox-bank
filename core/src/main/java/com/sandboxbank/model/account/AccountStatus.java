package com.sandboxbank.model.account;

public enum AccountStatus {

    ACTIVE("Active"),
    INACTIVE("Inactive"),
    CLOSED("Closed");

    private final String displayName;

    AccountStatus(String displayName) {

        this.displayName = displayName;
    }

    public String getDisplayName() {

        return displayName;
    }
}
