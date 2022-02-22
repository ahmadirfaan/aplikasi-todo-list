package com.irfaan.belajar.todolist.repository;


import com.irfaan.belajar.todolist.entity.Todolist;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Ahmad Irfaan Hibatullah
 * @version $Id: TodolistRepositoryImpl.java, v 0.1 2022‐02‐22 17.31 Ahmad Irfaan Hibatullah Exp $$
 */
public class TodolistRepositoryImpl implements TodolistRepository {

    private DataSource dataSource;

    public TodolistRepositoryImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public List<Todolist> getAll() {
        String sql = "SELECT id,todo FROM todolist";

        try (Connection connection = dataSource.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)
        ) {
            List<Todolist> todolists = new ArrayList<>();
            while (resultSet.next()) {
                Todolist todolist = new Todolist();
                todolist.setId(resultSet.getInt("id"));
                todolist.setTodo(resultSet.getString("todo"));

                todolists.add(todolist);
            }

            return todolists;

        } catch (SQLException exception) {
            throw new RuntimeException(exception);
        }

    }

    @Override
    public void add(Todolist todolist) {
        String sql = "INSERT INTO todolist(todo) VALUES (?)";

        try (Connection connection = dataSource.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, todolist.getTodo());
            statement.executeUpdate();

        } catch (SQLException exception) {
            throw new RuntimeException(exception);
        }

    }

    private boolean isExist(Integer number) {
        String sql = "SELECT id FROM todolist WHERE id = ?";

        try (Connection connection = dataSource.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, number);

            try (ResultSet resultSet = statement.executeQuery()) {
                return resultSet.next();
            }

        } catch (SQLException exception) {
            throw new RuntimeException(exception);
        }
    }

    @Override
    public boolean remove(Integer number) {

        if (isExist(number)) {

            String sql = "DELETE FROM todolist WHERE id = ?";

            try (Connection connection = dataSource.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, number);
                statement.executeUpdate();
                return true;
            } catch (SQLException exception) {
                throw new RuntimeException(exception);
            }

        } else {
            return false;
        }

    }

}