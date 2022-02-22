package test.service;

import entity.Todolist;
import repository.TodolistRepository;
import repository.TodolistRepositoryImpl;
import service.TodolistService;
import service.TodolistServiceImpl;

/**
 * @author Ahmad Irfaan Hibatullah
 * @version $Id: TodolistServiceTest.java, v 0.1 2022‐02‐22 17.38 Ahmad Irfaan Hibatullah Exp $$
 */
public class TodolistServiceTest {

    public static void main(String[] args) {
        testRemoveTodoList();
        testShowTodoList();
    }

    public static void testShowTodoList(){
        TodolistRepositoryImpl todoListRepository = new TodolistRepositoryImpl();
        todoListRepository.data[0] = new Todolist("Belajar Java Dasar");
        todoListRepository.data[1] = new Todolist("Belajar Java OOP");
        todoListRepository.data[2] = new Todolist("Belajar Java Standard Classes");

        TodolistService todoListService = new TodolistServiceImpl(todoListRepository);

        todoListService.showTodoList();
    }

    public static void testAddTodoList(){
        TodolistRepository todoListRepository = new TodolistRepositoryImpl();
        TodolistService todoListService = new TodolistServiceImpl(todoListRepository);

        todoListService.addTodoList("Belajar Java Dasar");
        todoListService.addTodoList("Belajar Java OOP");
        todoListService.addTodoList("Belajar Java Standard Classes");

        todoListService.showTodoList();
    }

    public static void testRemoveTodoList(){
        TodolistRepository todoListRepository = new TodolistRepositoryImpl();
        TodolistService todoListService = new TodolistServiceImpl(todoListRepository);

        todoListService.addTodoList("Belajar Java Dasar");
        todoListService.addTodoList("Belajar Java OOP");
        todoListService.addTodoList("Belajar Java Standard Classes");

        todoListService.showTodoList();

        todoListService.removeTodoList(5);
        todoListService.removeTodoList(2);
        todoListService.showTodoList();
        todoListService.removeTodoList(2);
        todoListService.showTodoList();
        todoListService.removeTodoList(2);
        todoListService.showTodoList();
        todoListService.removeTodoList(1);
        todoListService.showTodoList();
    }
}