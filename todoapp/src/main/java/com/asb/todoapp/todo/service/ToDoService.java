package com.asb.todoapp.todo.service;

import com.asb.todoapp.todo.controller.dto.ToDoDetailDTO;

import java.util.List;

public interface ToDoService {
    List<ToDoDetailDTO> getAll();
    void add();
    void publish();
}
