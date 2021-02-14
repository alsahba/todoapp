package com.asb.todoapp.todo.controller;

import com.asb.todoapp.todo.controller.dto.ToDoDetailDTO;
import com.asb.todoapp.todo.service.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/todo")
public class ToDoController {

    @Autowired
    private ToDoService toDoService;

    @GetMapping("/all")
    public List<ToDoDetailDTO> getAll() {
        return toDoService.getAll();
    }

    @GetMapping("/add")
    public boolean add() {
        toDoService.publish();
        return true;
    }

}
