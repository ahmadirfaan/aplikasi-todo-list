package com.irfaan.belajar.todolist.repository;


import com.irfaan.belajar.todolist.entity.Todolist;

import java.util.List;

/**
 * @author Ahmad Irfaan Hibatullah
 * @version $Id: TodolistRepository.java, v 0.1 2022‐02‐22 17.31 Ahmad Irfaan Hibatullah Exp $$
 */
public interface TodolistRepository {

    List<Todolist> getAll();

    void add(Todolist todolist);

    boolean remove(Integer number);

}