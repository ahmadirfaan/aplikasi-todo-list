package com.irfaan.belajar.todolist.repository;

import com.irfaan.belajar.todolist.entity.Todolist;
import com.irfaan.belajar.todolist.util.DatabaseUtil;
import com.zaxxer.hikari.HikariDataSource;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;


/**
 * @author Ahmad Irfaan Hibatullah
 * @version $Id: TodolistRepositoryImplTest.java, v 0.1 2022‐02‐22 18.17 Ahmad Irfaan Hibatullah Exp $$
 */
public class TodolistRepositoryImplTest {

    private HikariDataSource dataSource;

    private TodolistRepository todolistRepository;

    @BeforeEach
    void setUp() {
        dataSource = DatabaseUtil.getDataSource();
        todolistRepository = new TodolistRepositoryImpl(dataSource);
    }

    @Test
    void testAdd() {
        Todolist todolist = new Todolist();
        todolist.setTodo("Ahmad Irfaan");

        todolistRepository.add(todolist);

    }

    @Test
    void testRemove() {
        System.out.println(todolistRepository.remove(1));
        System.out.println(todolistRepository.remove(2));
        System.out.println(todolistRepository.remove(3));
        System.out.println(todolistRepository.remove(4));
    }

    @Test
    void testGetAll() {
        todolistRepository.add(new Todolist("Ahmad"));
        todolistRepository.add(new Todolist("Irfaan"));
        todolistRepository.add(new Todolist("Hibatullah"));

        List<Todolist> todolistList = todolistRepository.getAll();
        for(Todolist todolist: todolistList) {
            System.out.println(todolist.getId() + " : " + todolist.getTodo());
        }
    }

    @AfterEach
    void tearDown() {
        dataSource.close();
    }
}