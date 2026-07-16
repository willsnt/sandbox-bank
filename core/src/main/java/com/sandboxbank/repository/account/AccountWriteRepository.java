package com.sandboxbank.repository.account;

import com.sandboxbank.model.account.Account;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AccountWriteRepository {

    private final Connection connection;

    public AccountWriteRepository(Connection connection) {

        this.connection = connection;
    }

    private static final Logger logger = LoggerFactory.getLogger(AccountWriteRepository.class);

    public void save(Account account) {

        String sql = "INSERT INTO accounts (type, pin_hash, client_id) VALUES (?, ?, ?)";

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {

            pstmt.setString(1, account.getType().name());
            pstmt.setString(2, account.getPinHash());
            pstmt.setLong(3, account.getClientID());

            pstmt.executeUpdate();
            logger.debug("Account saved successfully.");
        } catch (SQLException e) {

            logger.error("Database error occurred while saving account.", e);
            throw new RuntimeException(e);
        } catch (RuntimeException e) {

            logger.error("Unexpected error occurred while saving account.", e);
            throw new RuntimeException(e);
        }
    }

    public void delete(Long accountID) {

        String sql = "DELETE FROM accounts WHERE account_id = ?";

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {

            pstmt.setLong(1, accountID);

            pstmt.executeUpdate();
            logger.debug("Account deleted successfully.");
        } catch (SQLException e) {

            logger.error("Database error occurred while deleting account.", e);
            throw new RuntimeException(e);
        }
    }
}
