package com.sandboxbank.repository.client;

import com.sandboxbank.model.client.Client;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ClientWriteRepository {

    private final Connection connection;

    public ClientWriteRepository(Connection connection) {

        this.connection = connection;
    }

    private static final Logger logger = LoggerFactory.getLogger(ClientWriteRepository.class);

    public void save(Client client) {

        String sql = "INSERT INTO clients (first_name, last_name, gender, birth_date, marital_status, document_number, phone_number, email, address_line1, address_line2, city, state, postal_code, occupation, monthly_income) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {

                pstmt.setString(1, client.getFirstName());
                pstmt.setString(2, client.getLastName());
                pstmt.setString(3, client.getGender().name());
                pstmt.setDate(4, java.sql.Date.valueOf(client.getBirthDate()));
                pstmt.setString(5, client.getMaritalStatus().name());
                pstmt.setString(6, client.getDocumentNumber());
                pstmt.setString(7, client.getPhoneNumber());
                pstmt.setString(8, client.getEmail());
                pstmt.setString(9, client.getAddressLine1());
                pstmt.setString(10, client.getAddressLine2());
                pstmt.setString(11, client.getCity());
                pstmt.setString(12, client.getState());
                pstmt.setString(13, client.getPostalCode());
                pstmt.setString(14, client.getOccupation());
                pstmt.setBigDecimal(15, client.getMonthlyIncome().getNumber().numberValue(BigDecimal.class));

                pstmt.executeUpdate();
                logger.debug("Client saved successfully.");
        } catch (SQLException e) {

            logger.error("Database error occurred while saving client.", e);
            throw new RuntimeException(e);
        } catch (RuntimeException e) {

            logger.error("Unexpected error occurred while saving client.", e);
            throw new RuntimeException(e);
        }
    }

    public void delete(Long clientID) {

        String sql = "DELETE FROM clients WHERE client_id = ?";

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {

                pstmt.setLong(1, clientID);

                pstmt.executeUpdate();
                logger.debug("Client deleted successfully.");
        } catch (SQLException e) {

            logger.error("Database error occurred while deleting client.", e);
            throw new RuntimeException(e);
        }
    }
}
