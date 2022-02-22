import repository.TodolistRepository;
import repository.TodolistRepositoryImpl;
import service.TodolistService;
import service.TodolistServiceImpl;
import view.TodolistView;

/**
 * @author Ahmad Irfaan Hibatullah
 * @version $Id: TodolistApp.java, v 0.1 2022‐02‐22 17.30 Ahmad Irfaan Hibatullah Exp $$
 */
public class TodolistApp {

    public static void main(String[] args) {
        TodolistRepository todolistRepository = new TodolistRepositoryImpl();
        TodolistService todoListService = new TodolistServiceImpl(todolistRepository);
        TodolistView todoListView = new TodolistView(todoListService);

        todoListView.showTodoList();
    }
}