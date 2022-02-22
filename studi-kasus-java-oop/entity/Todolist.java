package entity;

/**
 * @author Ahmad Irfaan Hibatullah
 * @version $Id: Todolist.java, v 0.1 2022‐02‐22 17.30 Ahmad Irfaan Hibatullah Exp $$
 */
public class Todolist {

    private String todo;

    public Todolist() {
    }

    public Todolist(String todo) {
        this.todo = todo;
    }

    public String getTodo() {
        return todo;
    }

    public void setTodo(String todo) {
        this.todo = todo;
    }
}