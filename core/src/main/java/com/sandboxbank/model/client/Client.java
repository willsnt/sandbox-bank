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

    private Account account;
    private User user;

    public Client(String firstName,
                  String lastName,
                  Gender gender,
                  LocalDate birthdate,
                  MaritalStatus maritalStatus,
                  String documentNumber,
                  String phoneNumber,
                  String email,
                  String addressLine1,
                  String addressLine2,
                  String city,
                  String state,
                  String postalCode,
                  String occupation,
                  MonetaryAmount monthlyIncome) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.birthDate = birthdate;
        this.maritalStatus = maritalStatus;
        this.documentNumber = documentNumber;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
        this.city = city;
        this.state = state;
        this.postalCode = postalCode;
        this.occupation = occupation;
        this.monthlyIncome = monthlyIncome;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    public Client(int clientID,
                  String firstName,
                  String lastName,
                  Gender gender,
                  LocalDate birthDate,
                  MaritalStatus maritalStatus,
                  String documentNumber,
                  String phoneNumber,
                  String email,
                  String addressLine1,
                  String addressLine2,
                  String city,
                  String state,
                  String postalCode,
                  String occupation,
                  MonetaryAmount monthlyIncome,
                  LocalDateTime createdAt,
                  LocalDateTime updatedAt,
                  Account account,
                  User user) {

        this.clientID = clientID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.birthDate = birthDate;
        this.maritalStatus = maritalStatus;
        this.documentNumber = documentNumber;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
        this.city = city;
        this.state = state;
        this.postalCode = postalCode;
        this.occupation = occupation;
        this.monthlyIncome = monthlyIncome;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.account = account;
        this.user = user;
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

    public String getFormattedMonthlyIncome() {

        MonetaryAmountFormat formatter = MonetaryFormats.getAmountFormat(
                AmountFormatQueryBuilder.of(Locale.US)
                        .set(CurrencyStyle.SYMBOL)
                        .build()
        );

        return formatter.format(monthlyIncome);
    }

    public LocalDateTime getCreatedAt() {

        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {

        return updatedAt;
    }

    public Account getAccount() {

        return account;
    }

    public User getUser() {

        return user;
    }
}
