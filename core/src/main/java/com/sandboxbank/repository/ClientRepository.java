package com.sandboxbank.repository;

import com.sandboxbank.model.client.Client;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.money.MonetaryAmount;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ClientRepository {

    private final Connection connection;

    public ClientRepository(Connection connection) {

        this.connection = connection;
    }

    private static final Logger logger = LoggerFactory.getLogger(ClientRepository.class);

    public void save(Client client) {

        String sql = "INSERT INTO clients (first_name, last_name, gender, birth_date, marital_status, document_number, phone_number, email, address_line1, address_line2, city, state, postal_code, occupation, monthly_income) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try {

            connection.setAutoCommit(false);

            try (PreparedStatement pstmt = connection.prepareStatement(sql)) {

                pstmt.setString(1, client.getFirstName());
                pstmt.setString(2, client.getLastName());
                pstmt.setString(3, client.getGender().getDescription());
                pstmt.setDate(4, java.sql.Date.valueOf(client.getBirthDate()));
                pstmt.setString(5, client.getMaritalStatus().getDescription());
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

                connection.commit();
                logger.debug("Client saved successfully: {}", client);
            } catch (SQLException e) {

                connection.rollback();
                logger.error("Failed to save client: {}", client, e);
                throw new RuntimeException(e);
            }
        } catch (SQLException e) {

            logger.error("Database error occurred while saving client: {}", client, e);
            throw new RuntimeException(e);
        } catch (RuntimeException e) {

            logger.error("Unexpected error occurred while saving client: {}", client, e);
            throw new RuntimeException(e);
        }
    }

    public void delete(int clientID) throws SQLException {

        String sql = "DELETE FROM clients WHERE client_id = ?";

        try {

            connection.setAutoCommit(false);

            try (PreparedStatement pstmt = connection.prepareStatement(sql)) {

                pstmt.setInt(1, clientID);

                pstmt.executeUpdate();

                connection.commit();
                logger.debug("Client deleted successfully: clientID={}", clientID);
            } catch (SQLException e) {

                connection.rollback();
                logger.error("Failed to delete client: clientID={}", clientID, e);
                throw new RuntimeException(e);
            }
        } catch (RuntimeException e) {

            logger.error("Unexpected error occurred while deleting client: clientID={}", clientID, e);
            throw new RuntimeException(e);
        }
    }

    public void update(String columnName, String newValue, int clientID) throws SQLException {

        String sql = "UPDATE clients SET " + columnName + " = ? WHERE client_id = ?";

        try {

            connection.setAutoCommit(false);

            try (PreparedStatement pstmt = connection.prepareStatement(sql)) {

                pstmt.setString(1, newValue);
                pstmt.setInt(2, clientID);

                pstmt.executeUpdate();

                connection.commit();
                logger.debug("Client updated successfully: clientID={}, columnName={}, newValue={}", clientID, columnName, newValue);
            } catch (SQLException e) {

                connection.rollback();
                logger.error("Failed to update client: clientID={}, columnName={}, newValue={}", clientID, columnName, newValue, e);
                throw new RuntimeException(e);
            }
        } catch (RuntimeException e) {

            logger.error("Unexpected error occurred while updating client: clientID={}, columnName={}, newValue={}", clientID, columnName, newValue, e);
            throw new RuntimeException(e);
        }
    }

    public void update(String columnName, MonetaryAmount newValue, int clientID) throws SQLException {

        String sql = "UPDATE clients SET " + columnName + " = ? WHERE client_id = ?";

        try {

            connection.setAutoCommit(false);

            try (PreparedStatement pstmt = connection.prepareStatement(sql)) {

                pstmt.setBigDecimal(1, newValue.getNumber().numberValue(BigDecimal.class));
                pstmt.setInt(2, clientID);

                pstmt.executeUpdate();

                connection.commit();
                logger.debug("Client updated successfully: clientID={}, columnName={}, newValue={}", clientID, columnName, newValue);
            } catch (SQLException e) {

                connection.rollback();
                logger.error("Failed to update client: clientID={}, columnName={}, newValue={}", clientID, columnName, newValue, e);
                throw new RuntimeException(e);
            }
        } catch (RuntimeException e) {

            logger.error("Unexpected error occurred while updating client: clientID={}, columnName={}, newValue={}", clientID, columnName, newValue, e);
            throw new RuntimeException(e);
        }
    }
}