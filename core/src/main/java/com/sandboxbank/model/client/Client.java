package com.sandboxbank.model.client;

import com.sandboxbank.model.account.Account;
import com.sandboxbank.model.user.User;
import org.javamoney.moneta.format.CurrencyStyle;

import javax.money.MonetaryAmount;
import javax.money.format.AmountFormatQueryBuilder;
import javax.money.format.MonetaryAmountFormat;
import javax.money.format.MonetaryFormats;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Locale;

public class Client {

    private int clientID;

    private String firstName;
    private String lastName;
    private Gender gender;
    private LocalDate birthDate;
    private MaritalStatus maritalStatus;

    private String documentNumber;
    private String phoneNumber;
    private String email;

    private String addressLine1;
    private String addressLine2;
    private String city;
    private String state;
    private String postalCode;

    private String occupation;
    private MonetaryAmount monthlyIncome;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    private Client(Builder builder) {

        this.clientID = builder.clientID;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.gender = builder.gender;
        this.birthDate = builder.birthDate;
        this.maritalStatus = builder.maritalStatus;
        this.documentNumber = builder.documentNumber;
        this.phoneNumber = builder.phoneNumber;
        this.email = builder.email;
        this.addressLine1 = builder.addressLine1;
        this.addressLine2 = builder.addressLine2;
        this.city = builder.city;
        this.state = builder.state;
        this.postalCode = builder.postalCode;
        this.occupation = builder.occupation;
        this.monthlyIncome = builder.monthlyIncome;
        this.createdAt = builder.createdAt;
        this.updatedAt = builder.updatedAt;
    }

    public static Builder builder() {

        return new Builder();
    }

    public static class Builder {

        private int clientID;

        private String firstName;
        private String lastName;
        private Gender gender;
        private LocalDate birthDate;
        private MaritalStatus maritalStatus;

        private String documentNumber;
        private String phoneNumber;
        private String email;

        private String addressLine1;
        private String addressLine2;
        private String city;
        private String state;
        private String postalCode;

        private String occupation;
        private MonetaryAmount monthlyIncome;

        private LocalDateTime createdAt;
        private LocalDateTime updatedAt;

        public Builder clientID(int clientID) {

            this.clientID = clientID;
            return this;
        }

        public Builder firstName(String firstName) {

            this.firstName = firstName;
            return this;
        }

        public Builder lastName(String lastName) {

            this.lastName = lastName;
            return this;
        }

        public Builder gender(Gender gender) {

            this.gender = gender;
            return this;
        }

        public Builder birthDate(LocalDate birthDate) {

            this.birthDate = birthDate;
            return this;
        }

        public Builder maritalStatus(MaritalStatus maritalStatus) {

            this.maritalStatus = maritalStatus;
            return this;
        }

        public Builder documentNumber(String documentNumber) {

            this.documentNumber = documentNumber;
            return this;
        }

        public Builder phoneNumber(String phoneNumber) {

            this.phoneNumber = phoneNumber;
            return this;
        }

        public Builder email(String email) {

            this.email = email;
            return this;
        }

        public Builder addressLine1(String addressLine1) {

            this.addressLine1 = addressLine1;
            return this;
        }

        public Builder addressLine2(String addressLine2) {

            this.addressLine2 = addressLine2;
            return this;
        }

        public Builder city(String city) {

            this.city = city;
            return this;
        }

        public Builder state(String state) {

            this.state = state;
            return this;
        }

        public Builder postalCode(String postalCode) {

            this.postalCode = postalCode;
            return this;
        }

        public Builder occupation(String occupation) {

            this.occupation = occupation;
            return this;
        }

        public Builder monthlyIncome(MonetaryAmount monthlyIncome) {

            this.monthlyIncome = monthlyIncome;
            return this;
        }

        public Builder createdAt(LocalDateTime createdAt) {

            this.createdAt = createdAt;
            return this;
        }

        public Builder updatedAt(LocalDateTime updatedAt) {

            this.updatedAt = updatedAt;
            return this;
        }

        public Client build() {
            return new Client(this);
        }
    }

    public int getClientID() {

        return clientID;
    }

    public String getFirstName() {

        return firstName;
    }

    public String getLastName() {

        return lastName;
    }

    public Gender getGender() {

        return gender;
    }

    public LocalDate getBirthDate() {

        return birthDate;
    }

    public MaritalStatus getMaritalStatus() {

        return maritalStatus;
    }

    public String getDocumentNumber() {

        return documentNumber;
    }

    public String getPhoneNumber() {

        return phoneNumber;
    }

    public String getEmail() {

        return email;
    }

    public String getAddressLine1() {

        return addressLine1;
    }

    public String getAddressLine2() {

        return addressLine2;
    }

    public String getCity() {

        return city;
    }

    public String getState() {

        return state;
    }

    public String getPostalCode() {

        return postalCode;
    }

    public String getOccupation() {

        return occupation;
    }

    public MonetaryAmount getMonthlyIncome() {

        return monthlyIncome;
    }

    public LocalDateTime getCreatedAt() {

        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {

        return updatedAt;
    }
}