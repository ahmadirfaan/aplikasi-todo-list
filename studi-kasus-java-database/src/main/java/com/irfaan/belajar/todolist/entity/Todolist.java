package com.irfaan.belajar.todolist.entity;

/**
 * @author Ahmad Irfaan Hibatullah
 * @version $Id: Todolist.java, v 0.1 2022‐02‐22 17.30 Ahmad Irfaan Hibatullah Exp $$
 */
public class Todolist {

    private Integer id;
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

    /**
     * Getter method for property id.
     *
     * @return property value of id
     */
    public Integer getId() {
        return id;
    }

    /**
     * Setter method for property id.
     *
     * @param id value to be assigned to property id
     */

    public void setId(Integer id) {
        this.id = id;
    }
}