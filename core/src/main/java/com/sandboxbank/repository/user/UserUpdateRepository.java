package com.sandboxbank.repository.user;

import com.sandboxbank.model.user.UserStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;

public class UserUpdateRepository {

    private final Connection connection;

    public UserUpdateRepository(Connection connection) {

        this.connection = connection;
    }

    private static final Logger logger = LoggerFactory.getLogger(UserUpdateRepository.class);

    private static final String DATABASE_ERROR_MESSAGE = "Database error occurred while updating user:";
    private static final String UNEXPECTED_ERROR_MESSAGE = "Unexpected error occurred while updating user";

    public void logDebug(Long userID, String column, String newValue) {

        logger.debug("User updated successfully:\n userID = {}\n column = {}\n New Value = {}", userID, column, newValue);
    }

    private void logDatabaseError(SQLException e) {

        logger.error(DATABASE_ERROR_MESSAGE, e);
    }

    private void logUnexpectedError(RuntimeException e) {

        logger.error(UNEXPECTED_ERROR_MESSAGE, e);
    }

    public void updatePasswordHash(Long userID, String newPasswordHash) {

        String sql = "UPDATE users SET password_hash = ? WHERE user_id = ?";

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {

            pstmt.setString(1, newPasswordHash);
            pstmt.setLong(2, userID);

            pstmt.executeUpdate();
            logDebug(userID, "password_hash", newPasswordHash);
        } catch (SQLException e) {

            logDatabaseError(e);
            throw new RuntimeException(e);
        } catch (RuntimeException e) {

            logUnexpectedError(e);
            throw new RuntimeException(e);
        }
    }

    public void updateStatus(Long userID, UserStatus newStatus) {

        String sql = "UPDATE users SET status = ? WHERE user_id = ?";

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {

            pstmt.setString(1, newStatus.name());
            pstmt.setLong(2, userID);

            pstmt.executeUpdate();
            logDebug(userID, "status", newStatus.name());
        } catch (SQLException e) {

            logDatabaseError(e);
            throw new RuntimeException(e);
        } catch (RuntimeException e) {

            logUnexpectedError(e);
            throw new RuntimeException(e);
        }
    }

    public void updateLastLogin(Long userID, LocalDateTime newLastLogin) {

        String sql = "UPDATE users SET last_login = ? WHERE user_id = ?";

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {

            pstmt.setTimestamp(1, Timestamp.valueOf(newLastLogin));
            pstmt.setLong(2, userID);

            pstmt.executeUpdate();
            logDebug(userID, "last_login", newLastLogin.toString());
        } catch (SQLException e) {

            logDatabaseError(e);
            throw new RuntimeException(e);
        } catch (RuntimeException e) {

            logUnexpectedError(e);
            throw new RuntimeException(e);
        }
    }

    public void updateLoginAttempts(Long userID, int newLoginAttempts) {

        String sql = "UPDATE users SET login_attempts = ? WHERE user_id = ?";

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {

            pstmt.setInt(1, newLoginAttempts);
            pstmt.setLong(2, userID);

            pstmt.executeUpdate();
            logDebug(userID, "login_attempts", String.valueOf(newLoginAttempts));
        } catch (SQLException e) {

            logDatabaseError(e);
            throw new RuntimeException(e);
        } catch (RuntimeException e) {

            logUnexpectedError(e);
            throw new RuntimeException(e);
        }
    }
}
