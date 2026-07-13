package com.sandboxbank.factory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    private static final Logger logger = LoggerFactory.getLogger(ConnectionFactory.class);

    public static Connection getConnection() {

        String url = getRequiredEnv("DB_URL", "Database URL is not set in environment variables");
        String username = getRequiredEnv("DB_USERNAME", "Database username is not set in environment variables");
        String password = getRequiredEnv("DB_PASSWORD", "Database password is not set in environment variables");

        try {

            Connection connection = DriverManager.getConnection(url, username, password);

            logger.debug("Database connection created successfully");
            return connection;
        } catch (SQLException e) {

            logger.error("Failed to create database connection {}", e.getMessage());
            throw new RuntimeException("Failed to create database connection", e);
        }
    }

    private static String getRequiredEnv(String key, String errorMessage) {

        String value = System.getenv(key);

        if (value == null || value.trim().isEmpty()) {

            logger.error(errorMessage);
            throw new RuntimeException(errorMessage);
        }
        return value;
    }
}
