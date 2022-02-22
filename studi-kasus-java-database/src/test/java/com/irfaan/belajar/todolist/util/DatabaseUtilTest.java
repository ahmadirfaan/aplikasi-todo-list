package com.irfaan.belajar.todolist.util;

import com.zaxxer.hikari.HikariDataSource;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author Ahmad Irfaan Hibatullah
 * @version $Id: DatabaseUtilTest.java, v 0.1 2022‐02‐22 18.01 Ahmad Irfaan Hibatullah Exp $$
 */
public class DatabaseUtilTest {

    @Test
    void testConnection() throws SQLException {
        HikariDataSource hikariDataSource = DatabaseUtil.getDataSource();

        Connection connection = hikariDataSource.getConnection();

        connection.close();

        hikariDataSource.close();
    }
}