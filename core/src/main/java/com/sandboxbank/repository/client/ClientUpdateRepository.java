package com.sandboxbank.repository.client;

import com.sandboxbank.model.client.Gender;
import com.sandboxbank.model.client.MaritalStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.money.MonetaryAmount;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

public class ClientUpdateRepository {

    private final Connection connection;

    public ClientUpdateRepository(Connection connection) {

        this.connection = connection;
    }

    private static final Logger logger = LoggerFactory.getLogger(ClientUpdateRepository.class);

    private static final String DATABASE_ERROR_MESSAGE = "Database error occurred while updating client:";
    private static final String UNEXPECTED_ERROR_MESSAGE = "Unexpected error occurred while updating client";

    public void logDebug(Long clientID, String column, String newValue) {

        logger.debug("Client updated successfully:\n clientID = {}\n column = {}\n New Value = {}", clientID, column, newValue);
    }

    private void logDatabaseError(SQLException e) {

        logger.error(DATABASE_ERROR_MESSAGE, e);
    }

    private void logUnexpectedError(RuntimeException e) {

        logger.error(UNEXPECTED_ERROR_MESSAGE, e);
    }

    public void updateFirstName(Long clientID, String newFirstName) {

        String sql = "UPDATE clients SET first_name = ? WHERE client_id = ?";

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {

                pstmt.setString(1, newFirstName);
                pstmt.setLong(2, clientID);

                pstmt.executeUpdate();
                logDebug(clientID, "first_name", newFirstName);
        } catch (SQLException e) {

            logDatabaseError(e);
            throw new RuntimeException(e);
        } catch (RuntimeException e) {

            logUnexpectedError(e);
            throw new RuntimeException(e);
        }
    }

    public void updateLastName(Long clientID, String newLastName) {

        String sql = "UPDATE clients SET last_name = ? WHERE client_id = ?";

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {

                pstmt.setString(1, newLastName);
                pstmt.setLong(2, clientID);

                pstmt.executeUpdate();
                logDebug(clientID, "last_name", newLastName);
        } catch (SQLException e) {

            logDatabaseError(e);
            throw new RuntimeException(e);
        } catch (RuntimeException e) {

            logUnexpectedError(e);
            throw new RuntimeException(e);
        }
    }

    public void updateGender(Long clientID, Gender newGender) {

        String sql = "UPDATE clients SET gender = ? WHERE client_id = ?";

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {

                pstmt.setString(1, newGender.name());
                pstmt.setLong(2, clientID);

                pstmt.executeUpdate();
                logDebug(clientID, "gender", newGender.name());
        } catch (SQLException e) {

            logDatabaseError(e);
            throw new RuntimeException(e);
        } catch (RuntimeException e) {

            logUnexpectedError(e);
            throw new RuntimeException(e);
        }
    }

    public void updateBirthDate(Long clientID, LocalDate newBirthDate) {

        String sql = "UPDATE clients SET birth_date = ? WHERE client_id = ?";

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {

                pstmt.setDate(1, Date.valueOf(newBirthDate));
                pstmt.setLong(2, clientID);

                pstmt.executeUpdate();
                logDebug(clientID, "birth_date", newBirthDate.toString());
        } catch (SQLException e) {

            logDatabaseError(e);
            throw new RuntimeException(e);
        } catch (RuntimeException e) {

            logUnexpectedError(e);
            throw new RuntimeException(e);
        }
    }

    public void updateMaritalStatus(Long clientID, MaritalStatus newMaritalStatus) {

        String sql = "UPDATE clients SET marital_status = ? WHERE client_id = ?";

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {

                pstmt.setString(1, newMaritalStatus.name());
                pstmt.setLong(2, clientID);

                pstmt.executeUpdate();
                logDebug(clientID, "marital_status", newMaritalStatus.name());
        } catch (SQLException e) {

            logDatabaseError(e);
            throw new RuntimeException(e);
        } catch (RuntimeException e) {

            logUnexpectedError(e);
            throw new RuntimeException(e);
        }
    }

    public void updateDocumentNumber(Long clientID, String newDocumentNumber) {

        String sql = "UPDATE clients SET document_number = ? WHERE client_id = ?";

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {

                pstmt.setString(1, newDocumentNumber);
                pstmt.setLong(2, clientID);

                pstmt.executeUpdate();
                logDebug(clientID, "document_number", newDocumentNumber);
        } catch (SQLException e) {

            logDatabaseError(e);
            throw new RuntimeException(e);
        } catch (RuntimeException e) {

            logUnexpectedError(e);
            throw new RuntimeException(e);
        }
    }

    public void updatePhoneNumber(Long clientID, String newPhoneNumber) {

        String sql = "UPDATE clients SET phone_number = ? WHERE client_id = ?";

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {

                pstmt.setString(1, newPhoneNumber);
                pstmt.setLong(2, clientID);

                pstmt.executeUpdate();
                logDebug(clientID, "phone_number", newPhoneNumber);
        } catch (SQLException e) {

            logDatabaseError(e);
            throw new RuntimeException(e);
        } catch (RuntimeException e) {

            logUnexpectedError(e);
            throw new RuntimeException(e);
        }
    }

    public void updateEmail(Long clientID, String newEmail) {

        String sql = "UPDATE clients SET email = ? WHERE client_id = ?";

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {

                pstmt.setString(1, newEmail);
                pstmt.setLong(2, clientID);

                pstmt.executeUpdate();
                logDebug(clientID, "email", newEmail);
        } catch (SQLException e) {

            logDatabaseError(e);
            throw new RuntimeException(e);
        } catch (RuntimeException e) {

            logUnexpectedError(e);
            throw new RuntimeException(e);
        }
    }

    public void updateAddressLine1(Long clientID, String newAddressLine1) {

        String sql = "UPDATE clients SET address_line1 = ? WHERE client_id = ?";

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {

                pstmt.setString(1, newAddressLine1);
                pstmt.setLong(2, clientID);

                pstmt.executeUpdate();
                logDebug(clientID, "address_line1", newAddressLine1);
        } catch (SQLException e) {

            logDatabaseError(e);
            throw new RuntimeException(e);
        } catch (RuntimeException e) {

            logUnexpectedError(e);
            throw new RuntimeException(e);
        }
    }

    public void updateAddressLine2(Long clientID, String newAddressLine2) {

        String sql = "UPDATE clients SET address_line2 = ? WHERE client_id = ?";

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {

                pstmt.setString(1, newAddressLine2);
                pstmt.setLong(2, clientID);

                pstmt.executeUpdate();
                logDebug(clientID, "address_line2", newAddressLine2);
        } catch (SQLException e) {

            logDatabaseError(e);
            throw new RuntimeException(e);
        } catch (RuntimeException e) {

            logUnexpectedError(e);
            throw new RuntimeException(e);
        }
    }

    public void updateCity(Long clientID, String newCity) {

        String sql = "UPDATE clients SET city = ? WHERE client_id = ?";

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {

                pstmt.setString(1, newCity);
                pstmt.setLong(2, clientID);

                pstmt.executeUpdate();
                logDebug(clientID, "city", newCity);
        } catch (SQLException e) {

            logDatabaseError(e);
            throw new RuntimeException(e);
        } catch (RuntimeException e) {

            logUnexpectedError(e);
            throw new RuntimeException(e);
        }
    }

    public void updateState(Long clientID, String newState) {

        String sql = "UPDATE clients SET state = ? WHERE client_id = ?";

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {

                pstmt.setString(1, newState);
                pstmt.setLong(2, clientID);

                pstmt.executeUpdate();
                logDebug(clientID, "state", newState);
        } catch (SQLException e) {

            logDatabaseError(e);
            throw new RuntimeException(e);
        } catch (RuntimeException e) {

            logUnexpectedError(e);
            throw new RuntimeException(e);
        }
    }

    public void updatePostalCode(Long clientID, String newPostalCode) {

        String sql = "UPDATE clients SET postal_code = ? WHERE client_id = ?";

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {

                pstmt.setString(1, newPostalCode);
                pstmt.setLong(2, clientID);

                pstmt.executeUpdate();
                logDebug(clientID, "postal_code", newPostalCode);
        } catch (SQLException e) {

            logDatabaseError(e);
            throw new RuntimeException(e);
        } catch (RuntimeException e) {

            logUnexpectedError(e);
            throw new RuntimeException(e);
        }
    }

    public void updateOccupation(Long clientID, String newOccupation) {

        String sql = "UPDATE clients SET occupation = ? WHERE client_id = ?";

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {

                pstmt.setString(1, newOccupation);
                pstmt.setLong(2, clientID);

                pstmt.executeUpdate();
                logDebug(clientID, "occupation", newOccupation);
        } catch (SQLException e) {

            logDatabaseError(e);
            throw new RuntimeException(e);
        } catch (RuntimeException e) {

            logUnexpectedError(e);
            throw new RuntimeException(e);
        }
    }

    public void updateMonthlyIncome(Long clientID, MonetaryAmount newMonthlyIncome) {

        String sql = "UPDATE clients SET monthly_income = ? WHERE client_id = ?";

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {

                pstmt.setBigDecimal(1, newMonthlyIncome.getNumber().numberValue(BigDecimal.class));
                pstmt.setLong(2, clientID);

                pstmt.executeUpdate();
                logDebug(clientID, "monthly_income", newMonthlyIncome.toString());
        } catch (SQLException e) {

            logDatabaseError(e);
            throw new RuntimeException(e);
        } catch (RuntimeException e) {

            logUnexpectedError(e);
            throw new RuntimeException(e);
        }
    }
}