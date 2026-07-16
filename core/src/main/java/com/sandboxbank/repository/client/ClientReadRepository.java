package com.sandboxbank.repository.client;

import com.sandboxbank.model.client.Client;
import com.sandboxbank.model.client.Gender;
import com.sandboxbank.model.client.MaritalStatus;
import org.javamoney.moneta.Money;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.money.MonetaryAmount;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class ClientReadRepository {

    private final Connection connection;

    public ClientReadRepository(Connection connection) {

        this.connection = connection;
    }

    private static final Logger logger = LoggerFactory.getLogger(ClientReadRepository.class);

    public boolean existsByDocumentNumber(String documentNumber) {

        String sql = "SELECT document_number FROM clients WHERE document_number = ?";

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {

            pstmt.setString(1, documentNumber);

            try (ResultSet rs = pstmt.executeQuery()) {

                return rs.next();
            }
        } catch (SQLException e) {

            logger.error("Database error occurred while consulting client.", e);
            throw new RuntimeException(e);
        } catch (RuntimeException e) {

            logger.error("Unexpected error occurred while consulting client.", e);
            throw new RuntimeException(e);
        }
    }

    public boolean existsByPhoneNumber(String phoneNumber) {

        String sql = "SELECT phone_number FROM clients WHERE phone_number = ?";

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {

            pstmt.setString(1, phoneNumber);

            try (ResultSet rs = pstmt.executeQuery()) {

                return rs.next();
            }
        } catch (SQLException e) {

            logger.error("Database error occurred while consulting client.", e);
            throw new RuntimeException(e);
        } catch (RuntimeException e) {

            logger.error("Unexpected error occurred while consulting client.", e);
            throw new RuntimeException(e);
        }
    }

    public boolean existsByEmail(String email) {

        String sql = "SELECT email FROM clients WHERE email = ?";

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {

            pstmt.setString(1, email);

            try (ResultSet rs = pstmt.executeQuery()) {

                return rs.next();
            }
        } catch (SQLException e) {

            logger.error("Database error occurred while consulting client.", e);
            throw new RuntimeException(e);
        } catch (RuntimeException e) {

            logger.error("Unexpected error occurred while consulting client.", e);
            throw new RuntimeException(e);
        }
    }

    public Client findByDocumentNumber(String documentNumber) {

        String sql = "SELECT * FROM clients WHERE document_number = ?";

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {

            pstmt.setString(1, documentNumber);

            try (ResultSet rs = pstmt.executeQuery()) {

                if (!rs.next()) {

                    return null;
                }

                Long clientID = rs.getLong("client_id");
                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");
                Gender gender = Gender.valueOf(rs.getString("gender"));
                LocalDate birthDate = (rs.getDate("birth_date").toLocalDate());
                MaritalStatus maritalStatus = MaritalStatus.valueOf(rs.getString("marital_status"));
                String foundDocumentNumber = rs.getString("document_number");
                String phoneNumber = rs.getString("phone_number");
                String email = rs.getString("email");
                String addressLine1 = rs.getString("address_line1");
                String addressLine2 = rs.getString("address_line2");
                String city = rs.getString("city");
                String state = rs.getString("state");
                String postalCode = rs.getString("postal_code");
                String occupation = rs.getString("occupation");
                MonetaryAmount monthlyIncome = Money.of(rs.getBigDecimal("monthly_income"), "USD");
                Timestamp createdAtTimestamp = rs.getTimestamp("created_at");
                Timestamp updatedAtTimestamp = rs.getTimestamp("updated_at");
                LocalDateTime createdAt = createdAtTimestamp != null ? createdAtTimestamp.toLocalDateTime() : null;
                LocalDateTime updatedAt = updatedAtTimestamp != null ? updatedAtTimestamp.toLocalDateTime() : null;

                return new Client.Builder()
                        .clientID(clientID)
                        .firstName(firstName)
                        .lastName(lastName)
                        .gender(gender)
                        .birthDate(birthDate)
                        .maritalStatus(maritalStatus)
                        .documentNumber(foundDocumentNumber)
                        .phoneNumber(phoneNumber)
                        .email(email)
                        .addressLine1(addressLine1)
                        .addressLine2(addressLine2)
                        .city(city)
                        .state(state)
                        .postalCode(postalCode)
                        .occupation(occupation)
                        .monthlyIncome(monthlyIncome)
                        .createdAt(createdAt)
                        .updatedAt(updatedAt)
                        .build();
            }
        } catch (SQLException e) {

            logger.error("Database error occurred while consulting client.", e);
            throw new RuntimeException(e);
        }
    }
}
