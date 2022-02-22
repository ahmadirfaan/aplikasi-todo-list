import java.util.Scanner;

/**
 * @author Ahmad Irfaan Hibatullah
 * @version $Id: ToDoListApp.java, v 0.1 2021‐11‐10 20.02 Ahmad Irfaan Hibatullah Exp $$
 */
public class ToDoListApp {

    public static String[] model = new String[10];

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        viewShowToDoList();
    }

    /**
     * show todo list
     */
    public static void showToDoList() {
        System.out.println("TODOLIST");
        for (int i = 0; i < model.length; i++) {
            String todo = model[i];
            int number = i + 1;
            if (todo != null) {
                System.out.println(number + ". " + todo);
            }
        }
    }

    public static void testShowToDoList() {
        model[0] = "Learning Basic Java";
        model[0] = "Case Study Java Basic : Application Todo List";
        showToDoList();
    }

    /**
     * add todo to list
     */
    public static void addToDoList(String todo) {
        // check the model is full or not
        boolean isFull = true;
        for (int i = 0; i < model.length; i++) {
            if (model[i] == null) {
                isFull = false;
                break;
            }
        }

        // is the length of array full then resize size array x 2
        if (isFull) {
            String[] temp = model;
            model = new String[model.length * 2];

            for (int i = 0; i < temp.length; i++) {
                model[i] = temp[i];
            }
        }

            // add to position array if element is null
            for (int i = 0; i < model.length; i++) {
                if (model[i] == null) {
                    model[i] = todo;
                    break;
                }
            }
    }

    public static void testAddToDoList() {
        for (int i = 0; i < 25; i++) {
            addToDoList("Contoh todo ke " + i );
        }

        showToDoList();
    }

    /**
     * remove todo from list
     */
    public static boolean removeToDoList(Integer number) {
        Integer index = number - 1;
        if(index >= model.length) {
            return false;
        }
        else if(model[index] == null) {
            return false;
        } else {
            for (int i = index; i < model.length; i++) {
                if(i == model.length - 1) {
                    model[i] = null;
                } else {
                    model[i] = model[i + 1];
                }
            }
            return true;
        }
    }

    public static void testRemoveToDoList() {
        addToDoList("Satu");
        addToDoList("Dua");
        addToDoList("Tiga");
        addToDoList("Empat");
        addToDoList("Lima");

        boolean result = removeToDoList(20);
        System.out.println(result);

        result = removeToDoList(7);
        System.out.println(result);

        result = removeToDoList(2);
        System.out.println(result);

        showToDoList();
    }

    public static String input(String info) {
        System.out.print(info + " : ");
        String data = scanner.nextLine();
        return data;
    }

    public static void testInput() {
        String name = input("Nama");
        System.out.println("Hi " + name);

        String channel = input("Channel");
        System.out.println(channel);
    }

    /**
     * show view todo  list
     */
    public static void viewShowToDoList() {
        while (true) {
            showToDoList();
            System.out.println("MENU: ");
            System.out.println("1. Add");
            System.out.println("2. Remove");
            System.out.println("x. Out");
            String input = input("Choose");
            if (input.equals("1")) {
                viewAddToDoList();
            } else if (input.equals("2")){
                viewRemoveToDoList();
            } else if (input.equals("3")) {
                break;
            } else {
                System.out.println("Choice not understood");
            }
        }
    }

    public static void testViewShowToDoList() {
        addToDoList("Satu");
        addToDoList("Dua");
        addToDoList("Tiga");
        addToDoList("Empat");
        addToDoList("Lima");
        viewShowToDoList();
    }

    /**
     * show view add todo  list
     */
    public static void viewAddToDoList() {
        System.out.println("ADD TODOLIST");
        String todo = input("Todo(x is canceled)");
        if (todo.equals("x")) {
            //canceled
        } else {
            addToDoList(todo);
        }
    }

    public static void testViewAddToDoList() {
        addToDoList("Satu");
        addToDoList("Dua");
        viewAddToDoList();

        showToDoList();
    }

    /**
     * show view remove todo from list
     */
    public static void viewRemoveToDoList() {
        System.out.println("REMOVE TODOLIST");
        String number = input("Number Todo(x is canceled)");
        if (number.equals("x")) {
            //canceled
        } else {
            boolean success = removeToDoList(Integer.valueOf(number));
            if(!success) {
                System.out.println("Failed to remove todolist : " + number);
            }
        }
    }

    public static void testViewRemoveToDoList() {

        addToDoList("Satu");
        addToDoList("Dua");
        addToDoList("Tiga");

        showToDoList();

        viewRemoveToDoList();

        showToDoList();
    }
}