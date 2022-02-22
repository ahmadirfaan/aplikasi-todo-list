package com.irfaan.belajar.todolist.service;


import com.irfaan.belajar.todolist.entity.Todolist;
import com.irfaan.belajar.todolist.repository.TodolistRepository;
import com.irfaan.belajar.todolist.repository.TodolistRepositoryImpl;
import com.irfaan.belajar.todolist.util.DatabaseUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.sql.DataSource;

/**
 * @author Ahmad Irfaan Hibatullah
 * @version $Id: TodolistServiceTest.java, v 0.1 2022‐02‐22 17.38 Ahmad Irfaan Hibatullah Exp $$
 */
public class TodolistServiceTest {

    private DataSource dataSource;

    private TodolistRepository todolistRepository;

    private TodolistService todolistService;


    @BeforeEach
    void setUp() {
        dataSource = DatabaseUtil.getDataSource();
        todolistRepository = new TodolistRepositoryImpl(dataSource);
        todolistService = new TodolistServiceImpl(todolistRepository);
    }

    @Test
    void testShowTodoList() {
        todolistRepository.add(new Todolist("Belajar Java Dasar"));
        todolistRepository.add(new Todolist("Belajar Java OOP"));
        todolistRepository.add(new Todolist("Belajar Java Standard Classes"));
        TodolistService todoListService = new TodolistServiceImpl(todolistRepository);

        todoListService.showTodoList();
    }

    @Test
    void testAddTodoList() {


        todolistService.addTodoList("Belajar Java Dasar");
        todolistService.addTodoList("Belajar Java OOP");
        todolistService.addTodoList("Belajar Java Standard Classes");

        todolistService.showTodoList();
    }

    @Test
    void testRemoveTodoList() {

        todolistService.addTodoList("Belajar Java Dasar");
        todolistService.addTodoList("Belajar Java OOP");
        todolistService.addTodoList("Belajar Java Standard Classes");

        todolistService.showTodoList();

        todolistService.removeTodoList(5);
        todolistService.removeTodoList(2);
        todolistService.showTodoList();
        todolistService.removeTodoList(2);
        todolistService.showTodoList();
        todolistService.removeTodoList(2);
        todolistService.showTodoList();
        todolistService.removeTodoList(1);
        todolistService.showTodoList();
    }
}