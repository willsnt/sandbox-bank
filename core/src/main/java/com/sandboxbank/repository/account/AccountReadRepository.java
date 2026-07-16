package com.sandboxbank.repository.account;

import com.sandboxbank.model.account.Account;
import com.sandboxbank.model.account.AccountStatus;
import com.sandboxbank.model.account.AccountType;
import org.javamoney.moneta.Money;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.money.MonetaryAmount;
import java.sql.*;
import java.time.LocalDateTime;

public class AccountReadRepository {

    private final Connection connection;

    public AccountReadRepository(Connection connection) {

        this.connection = connection;
    }

    private static final Logger logger = LoggerFactory.getLogger(AccountReadRepository.class);

    public boolean existsByAccountNumber(Long accountNumber) {

        String sql = "SELECT account_number FROM accounts WHERE account_number = ?";

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {

            pstmt.setLong(1, accountNumber);

            try (ResultSet rs = pstmt.executeQuery()) {

                return rs.next();
            }
        } catch (SQLException e) {

            logger.error("Database error occurred while consulting account.", e);
            throw new RuntimeException(e);
        } catch (RuntimeException e) {

            logger.error("Unexpected error occurred while consulting account.", e);
            throw new RuntimeException(e);
        }
    }

    public Account findByAccountNumber(Long accountNumber, Long clientID) {

        String sql = "SELECT * FROM accounts WHERE account_number = ?";

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {

            pstmt.setLong(1, accountNumber);

            try (ResultSet rs = pstmt.executeQuery()) {

                if (!rs.next()) {

                    return null;
                }

                Long accountID = rs.getLong("account_id");
                Long foundAccountNumber = rs.getLong("account_number");
                AccountType type = AccountType.valueOf(rs.getString("type"));
                AccountStatus status = AccountStatus.valueOf(rs.getString("status"));
                Timestamp lastAccessTimeStamp = rs.getTimestamp("last_access");
                LocalDateTime lastAccess = lastAccessTimeStamp != null ? rs.getTimestamp("last_access").toLocalDateTime() : null;
                String pinHash = rs.getString("pin_hash");
                int pinAttempts = rs.getInt("pin_attempts");
                Timestamp lastPinAttemptTimeStamp = rs.getTimestamp("last_pin_attempt");
                LocalDateTime lastPinAttempt = lastPinAttemptTimeStamp != null ? rs.getTimestamp("last_pin_attempt").toLocalDateTime() : null;
                MonetaryAmount balance = Money.of(rs.getBigDecimal("balance"),"USD");
                Timestamp lockedUntilTimeStamp = rs.getTimestamp("locked_until");
                LocalDateTime lockedUntil = lockedUntilTimeStamp != null ? rs.getTimestamp("locked_until").toLocalDateTime() : null;
                Timestamp createdAtTimeStamp = rs.getTimestamp("created_at");
                LocalDateTime createdAt = createdAtTimeStamp != null ? rs.getTimestamp("created_at").toLocalDateTime() : null;
                Timestamp updatedAtTimeStamp = rs.getTimestamp("updated_at");
                LocalDateTime updatedAt = updatedAtTimeStamp != null ? rs.getTimestamp("updated_at").toLocalDateTime() : null;

                return new Account(accountID, foundAccountNumber, type, status, lastAccess, pinHash, pinAttempts, lastPinAttempt, balance, lockedUntil, createdAt, updatedAt, clientID);
            }
        } catch (SQLException e) {

            logger.error("Database error occurred while consulting account.", e);
            throw new RuntimeException(e);
        }
    }
}
