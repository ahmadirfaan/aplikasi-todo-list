package com.irfaan.belajar.todolist.util;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

/**
 * @author Ahmad Irfaan Hibatullah
 * @version $Id: DatabaseUtil.java, v 0.1 2022‐02‐22 17.56 Ahmad Irfaan Hibatullah Exp $$
 */
public class DatabaseUtil {

    private static HikariDataSource hikariDataSource;

    static {
        HikariConfig hikariConfig = new HikariConfig();
        hikariConfig.setDriverClassName("com.mysql.cj.jdbc.Driver");
        hikariConfig.setUsername("root");
        hikariConfig.setPassword("P@ssw0rd");
        hikariConfig.setJdbcUrl("jdbc:mysql://0.0.0.0:3306/belajar_java_todolist?serverTimezone=Asia/Jakarta");

        // setting pool
        hikariConfig.setMaximumPoolSize(10);
        hikariConfig.setMinimumIdle(5);
        hikariConfig.setIdleTimeout(60_000);
        hikariConfig.setMaxLifetime(60 * 60 * 1000);

        hikariDataSource = new HikariDataSource(hikariConfig);

    }
    public static HikariDataSource getDataSource() {
        return hikariDataSource;
    }
}