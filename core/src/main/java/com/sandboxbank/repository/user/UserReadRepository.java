package com.sandboxbank.repository.user;

import com.sandboxbank.model.user.User;
import com.sandboxbank.model.user.UserStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.time.LocalDateTime;

public class UserReadRepository {

    private final Connection connection;

    public UserReadRepository(Connection connection) {

        this.connection = connection;
    }

    private static final Logger logger = LoggerFactory.getLogger(UserReadRepository.class);

    public boolean existsByUsername(String username) {

        String sql = "SELECT username FROM users WHERE username = ?";

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {

            pstmt.setString(1, username);

            try (ResultSet rs = pstmt.executeQuery()) {

                return rs.next();
            }
        } catch (SQLException e) {

            logger.error("Database error occurred while consulting user.", e);
            throw new RuntimeException(e);
        } catch (RuntimeException e) {

            logger.error("Unexpected error occurred while consulting user.", e);
            throw new RuntimeException(e);
        }
    }

    public User findByUsername(String username, Long clientID) {

        String sql = "SELECT * FROM users WHERE username = ?";

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {

            pstmt.setString(1, username);

            try (ResultSet rs = pstmt.executeQuery()) {

                if (!rs.next()) {

                    return null;
                }

                Long userID = rs.getLong("user_id");
                String foundUsername = rs.getString("username");
                String passwordHash = rs.getString("password_hash");
                UserStatus status = UserStatus.valueOf(rs.getString("status"));
                Timestamp lastLoginTimeStamp = rs.getTimestamp("last_login");
                LocalDateTime lastLogin = lastLoginTimeStamp != null ? rs.getTimestamp("last_login").toLocalDateTime() : null;
                int loginAttempts = rs.getInt("login_attempts");
                Timestamp lockedUntilTimeStamp = rs.getTimestamp("locked_until");
                LocalDateTime lockedUntil = lockedUntilTimeStamp != null ? rs.getTimestamp("locked_until").toLocalDateTime() : null;
                Timestamp createdAtTimeStamp = rs.getTimestamp("created_at");
                LocalDateTime createdAt = createdAtTimeStamp != null ? rs.getTimestamp("created_at").toLocalDateTime() : null;
                Timestamp updatedAtTimeStamp = rs.getTimestamp("updated_at");
                LocalDateTime updatedAt = updatedAtTimeStamp != null ? rs.getTimestamp("updated_at").toLocalDateTime() : null;

                return new User(userID, foundUsername, passwordHash, status, lastLogin, loginAttempts, lockedUntil, createdAt, updatedAt, clientID);
            }
        } catch (SQLException e) {

            logger.error("Database error occurred while consulting client.", e);
            throw new RuntimeException(e);
        }
    }
}
