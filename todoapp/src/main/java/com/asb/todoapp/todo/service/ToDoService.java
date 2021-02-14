package com.asb.todoapp.todo.service;

import com.asb.todoapp.todo.controller.dto.ToDoDetailDTO;
import com.asb.todoapp.todo.entity.ToDo;
import com.asb.todoapp.todo.producer.pojo.AddToDoPojo;
import com.asb.todoapp.todo.producer.pojo.UpdateToDoPojo;

import java.util.List;

public interface ToDoService {
    List<ToDoDetailDTO> getAll();
    void add(ToDo toDo);
    void update(ToDo toDo);
    void publishForAdd(AddToDoPojo addToDoPojo);
    void publishForUpdate(UpdateToDoPojo updateToDoPojo);
}
