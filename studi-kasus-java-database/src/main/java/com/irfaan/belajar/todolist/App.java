package com.irfaan.belajar.todolist;

import com.irfaan.belajar.todolist.repository.TodolistRepository;
import com.irfaan.belajar.todolist.repository.TodolistRepositoryImpl;
import com.irfaan.belajar.todolist.service.TodolistService;
import com.irfaan.belajar.todolist.service.TodolistServiceImpl;
import com.irfaan.belajar.todolist.util.DatabaseUtil;
import com.irfaan.belajar.todolist.view.TodolistView;

import javax.sql.DataSource;

/**
 * Hello world!
 */
public class App {

    public static void main(String[] args) {
        DataSource dataSource = DatabaseUtil.getDataSource();
        TodolistRepository todolistRepository = new TodolistRepositoryImpl(dataSource);
        TodolistService todolistService = new TodolistServiceImpl(todolistRepository);
        TodolistView todolistView = new TodolistView(todolistService);

        todolistView.showTodoList();
    }
}
