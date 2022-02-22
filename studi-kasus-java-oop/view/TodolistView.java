package view;

import service.TodolistService;
import util.InputUtil;

/**
 * @author Ahmad Irfaan Hibatullah
 * @version $Id: TodolistView.java, v 0.1 2022‐02‐22 17.35 Ahmad Irfaan Hibatullah Exp $$
 */
public class TodolistView {

    private final TodolistService todoListService;

    public TodolistView(TodolistService todoListService) {
        this.todoListService = todoListService;
    }

    public void showTodoList(){
        label:
        while (true) {
            todoListService.showTodoList();

            System.out.println("MENU : ");
            System.out.println("1. Tambah");
            System.out.println("2. Hapus");
            System.out.println("x. Keluar");

            var input = InputUtil.input("Pilih");

            switch (input) {
                case "1":
                    addTodoList();
                    break;
                case "2":
                    removeTodoList();
                    break;
                case "x":
                    break label;
                default:
                    System.out.println("Pilihan tidak dimengerti");
                    break;
            }
        }
    }

    public void addTodoList(){
        System.out.println("MENAMBAH TODOLIST");

        var todo = InputUtil.input("Todo (x Jika Batal)");

        if (todo.equals("x")) {
            System.out.println("Batal");
        } else {
            todoListService.addTodoList(todo);
        }
    }

    public void removeTodoList(){
        System.out.println("MENGHAPUS TODOLIST");

        var number = InputUtil.input("Nomor yang Dihapus (x Jika Batal)");

        if (number.equals("x")) {
            System.out.println("Batal");
        } else {
            todoListService.removeTodoList(Integer.valueOf(number));
        }
    }
}