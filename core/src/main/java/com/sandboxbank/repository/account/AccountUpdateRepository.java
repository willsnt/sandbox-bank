package com.sandboxbank.repository.account;

import com.sandboxbank.model.account.AccountStatus;
import com.sandboxbank.model.account.AccountType;
import com.sandboxbank.repository.user.UserUpdateRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.money.MonetaryAmount;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;

public class AccountUpdateRepository {

    private final Connection connection;

    public AccountUpdateRepository(Connection connection) {

        this.connection = connection;
    }

    private static final Logger logger = LoggerFactory.getLogger(AccountUpdateRepository.class);

    private static final String DATABASE_ERROR_MESSAGE = "Database error occurred while updating account:";
    private static final String UNEXPECTED_ERROR_MESSAGE = "Unexpected error occurred while updating account";

    public void logDebug(Long accountID, String column, String newValue) {

        logger.debug("Account updated successfully:\n accountID = {}\n column = {}\n New Value = {}", accountID, column, newValue);
    }

    private void logDatabaseError(SQLException e) {

        logger.error(DATABASE_ERROR_MESSAGE, e);
    }

    private void logUnexpectedError(RuntimeException e) {

        logger.error(UNEXPECTED_ERROR_MESSAGE, e);
    }

    public void updateType(Long accountID, AccountType newType) {

        String sql = "UPDATE accounts SET type = ? WHERE account_id = ?";

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {

            pstmt.setString(1, newType.name());
            pstmt.setLong(2, accountID);

            pstmt.executeUpdate();
            logDebug(accountID, "type", newType.name());
        } catch (SQLException e) {

            logDatabaseError(e);
            throw new RuntimeException(e);
        } catch (RuntimeException e) {

            logUnexpectedError(e);
            throw new RuntimeException(e);
        }
    }

    public void updateStatus(Long accountID, AccountStatus newStatus) {

        String sql = "UPDATE accounts SET status = ? WHERE account_id = ?";

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {

            pstmt.setString(1, newStatus.name());
            pstmt.setLong(2, accountID);

            pstmt.executeUpdate();
            logDebug(accountID, "status", newStatus.name());
        } catch (SQLException e) {

            logDatabaseError(e);
            throw new RuntimeException(e);
        } catch (RuntimeException e) {

            logUnexpectedError(e);
            throw new RuntimeException(e);
        }
    }

    public void updatePinHash(Long accountID, String newPinHash) {

        String sql = "UPDATE accounts SET pin_hash = ? WHERE account_id = ?";

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {

            pstmt.setString(1, newPinHash);
            pstmt.setLong(2, accountID);

            pstmt.executeUpdate();
            logDebug(accountID, "pin_hash", newPinHash);
        } catch (SQLException e) {

            logDatabaseError(e);
            throw new RuntimeException(e);
        } catch (RuntimeException e) {

            logUnexpectedError(e);
            throw new RuntimeException(e);
        }
    }

    public void updateBalance(Long accountID, MonetaryAmount newBalance) {

        String sql = "UPDATE accounts SET balance = ? WHERE account_id = ?";

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {

            pstmt.setBigDecimal(1, newBalance.getNumber().numberValue(BigDecimal.class));
            pstmt.setLong(2, accountID);

            pstmt.executeUpdate();
            logDebug(accountID, "balance", newBalance.toString());
        } catch (SQLException e) {

            logDatabaseError(e);
            throw new RuntimeException(e);
        } catch (RuntimeException e) {

            logUnexpectedError(e);
            throw new RuntimeException(e);
        }
    }

    public void updateLastAccess(Long accountID, LocalDateTime newLastAccess) {

        String sql = "UPDATE accounts SET last_access = ? WHERE account_id = ?";

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {

            pstmt.setTimestamp(1, Timestamp.valueOf(newLastAccess));
            pstmt.setLong(2, accountID);

            pstmt.executeUpdate();
            logDebug(accountID, "last_access", newLastAccess.toString());
        } catch (SQLException e) {

            logDatabaseError(e);
            throw new RuntimeException(e);
        } catch (RuntimeException e) {

            logUnexpectedError(e);
            throw new RuntimeException(e);
        }
    }

    public void updatePinAttempts(Long accountID, int newPinAttempts) {

        String sql = "UPDATE accounts SET pin_attempts = ? WHERE account_id = ?";

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {

            pstmt.setInt(1, newPinAttempts);
            pstmt.setLong(2, accountID);

            pstmt.executeUpdate();
            logDebug(accountID, "pin_attempts", Integer.toString(newPinAttempts));
        } catch (SQLException e) {

            logDatabaseError(e);
            throw new RuntimeException(e);
        } catch (RuntimeException e) {

            logUnexpectedError(e);
            throw new RuntimeException(e);
        }
    }

    public void updateLastPinAttempt(Long accountID, LocalDateTime newLastPinAttempt) {

        String sql = "UPDATE accounts SET last_pin_attempt = ? WHERE account_id = ?";

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {

            pstmt.setTimestamp(1, Timestamp.valueOf(newLastPinAttempt));
            pstmt.setLong(2, accountID);

            pstmt.executeUpdate();
            logDebug(accountID, "last_pin_attempt", newLastPinAttempt.toString());
        } catch (SQLException e) {

            logDatabaseError(e);
            throw new RuntimeException(e);
        } catch (RuntimeException e) {

            logUnexpectedError(e);
            throw new RuntimeException(e);
        }
    }

    public void updateLockedUntil(Long accountID, LocalDateTime newLockedUntil) {

        String sql = "UPDATE accounts SET locked_until = ? WHERE account_id = ?";

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {

            pstmt.setTimestamp(1, Timestamp.valueOf(newLockedUntil));
            pstmt.setLong(2, accountID);

            pstmt.executeUpdate();
            logDebug(accountID, "locked_until", newLockedUntil.toString());
        } catch (SQLException e) {

            logDatabaseError(e);
            throw new RuntimeException(e);
        } catch (RuntimeException e) {

            logUnexpectedError(e);
            throw new RuntimeException(e);
        }
    }
}
