package com.irfaan.belajar.todolist.service;


import com.irfaan.belajar.todolist.entity.Todolist;
import com.irfaan.belajar.todolist.repository.TodolistRepository;

import java.util.List;

/**
 * @author Ahmad Irfaan Hibatullah
 * @version $Id: TodolistServiceImpl.java, v 0.1 2022‐02‐22 17.33 Ahmad Irfaan Hibatullah Exp $$
 */
public class TodolistServiceImpl implements TodolistService {

    private final TodolistRepository todoListRepository;

    public TodolistServiceImpl(TodolistRepository todoListRepository) {
        this.todoListRepository = todoListRepository;
    }

    @Override
    public void showTodoList() {
        List<Todolist> model = todoListRepository.getAll();

        System.out.println("TODOLIST");
        for (Todolist todolist : model){
            System.out.println(todolist.getId() + "." + todolist.getTodo());
        }
    }

    @Override
    public void addTodoList(String todo) {
        Todolist todolist = new Todolist(todo);
        todoListRepository.add(todolist);
        System.out.println("SUKSES MENAMBAH TODO : " + todo);
    }

    @Override
    public void removeTodoList(Integer number) {
        boolean success = todoListRepository.remove(number);
        if (success) {
            System.out.println("SUKSES MENGHAPUS TODO : " + number);
        } else {
            System.out.println("GAGAL MENGHAPUS TODO : " + number);
        }
    }
}