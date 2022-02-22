package service;

/**
 * @author Ahmad Irfaan Hibatullah
 * @version $Id: TodolistService.java, v 0.1 2022‐02‐22 17.32 Ahmad Irfaan Hibatullah Exp $$
 */
public interface TodolistService {

    void showTodoList();

    void addTodoList(String todo);

    void removeTodoList(Integer number);
}