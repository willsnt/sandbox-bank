package com.sandboxbank.repository.user;

import com.sandboxbank.model.user.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserWriteRepository {

    private final Connection connection;

    public UserWriteRepository(Connection connection) {

        this.connection = connection;
    }

    private static final Logger logger = LoggerFactory.getLogger(UserWriteRepository.class);

    public void save(User user) {

        String sql = "INSERT INTO users (username, password_hash, status, client_id) VALUES (?, ?, ?, ?)";

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {

            pstmt.setString(1, user.getUsername());
            pstmt.setString(2, user.getPasswordHash());
            pstmt.setString(3, user.getStatus().name());
            pstmt.setLong(4, user.getClientID());

            pstmt.executeUpdate();
            logger.debug("User saved successfully.");
        } catch (SQLException e) {

            logger.error("Database error occurred while saving user.", e);
            throw new RuntimeException(e);
        } catch (RuntimeException e) {

            logger.error("Unexpected error occurred while saving user.", e);
            throw new RuntimeException(e);
        }
    }

    public void delete(Long userID) {

        String sql = "DELETE FROM users WHERE user_id = ?";

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {

            pstmt.setLong(1, userID);

            pstmt.executeUpdate();
            logger.debug("User deleted successfully.");
        } catch (SQLException e) {

            logger.error("Database error occurred while deleting user.", e);
            throw new RuntimeException(e);
        }
    }
}
