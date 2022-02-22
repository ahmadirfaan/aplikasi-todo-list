
package test.view;

import repository.TodolistRepository;
import repository.TodolistRepositoryImpl;
import service.TodolistService;
import service.TodolistServiceImpl;
import view.TodolistView;

/**
 * @author Ahmad Irfaan Hibatullah
 * @version $Id: TodolistViewTest.java, v 0.1 2022‐02‐22 17.40 Ahmad Irfaan Hibatullah Exp $$
 */
public class TodolistViewTest {

    public static void main(String[] args) {
        testShowTodoList();
        testRemoveTodoList();
    }

    public static void testShowTodoList(){
        TodolistRepository todoListRepository = new TodolistRepositoryImpl();
        TodolistService todoListService = new TodolistServiceImpl(todoListRepository);
        TodolistView todoListView = new TodolistView(todoListService);

        todoListService.addTodoList("Belajar Java Dasar");
        todoListService.addTodoList("Belajar Java OOP");
        todoListService.addTodoList("Belajar Java Standard Classes");

        todoListView.showTodoList();
    }

    public static void testAddTodoList(){
        TodolistRepository todoListRepository = new TodolistRepositoryImpl();
        TodolistService todoListService = new TodolistServiceImpl(todoListRepository);
        TodolistView todoListView = new TodolistView(todoListService);

        todoListView.addTodoList();

        todoListService.showTodoList();

        todoListView.addTodoList();

        todoListService.showTodoList();
    }

    public static void testRemoveTodoList(){
        TodolistRepository todoListRepository = new TodolistRepositoryImpl();
        TodolistService todoListService = new TodolistServiceImpl(todoListRepository);
        TodolistView todoListView = new TodolistView(todoListService);

        todoListService.addTodoList("Belajar Java Dasar");
        todoListService.addTodoList("Belajar Java OOP");
        todoListService.addTodoList("Belajar Java Standard Classes");

        todoListService.showTodoList();

        todoListView.removeTodoList();

        todoListService.showTodoList();
    }
}