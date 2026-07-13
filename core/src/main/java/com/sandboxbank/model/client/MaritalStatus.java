package com.sandboxbank.model.client;

public enum MaritalStatus {

    SINGLE("Single"),
    MARRIED("Married"),
    DIVORCED("Divorced"),
    WIDOWED("Widowed");

    private final String description;

    MaritalStatus(String description) {

        this.description = description;
    }

    public String getDescription() {

        return description;
    }
}