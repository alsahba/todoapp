package com.asb.todoapp.todo.service;

import com.asb.todoapp.todo.entity.ToDo;
import com.asb.todoapp.todo.controller.dto.ToDoDetailDTO;
import com.asb.todoapp.todo.producer.ToDoProducer;
import com.asb.todoapp.todo.repository.ToDoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ToDoServiceImpl implements ToDoService {

    @Autowired
    private ToDoRepository toDoRepository;

    @Autowired
    private ToDoProducer toDoProducer;

    @Override
    public List<ToDoDetailDTO> getAll() {
        return toDoRepository.findAll().stream().map(ToDoDetailDTO::new).collect(Collectors.toList());
    }

    @Override
    public void add() {
        ToDo toDo = new ToDo();
        toDo.setExplanation("something");
        toDoRepository.save(toDo);
    }

    @Override
    public void publish() {
        toDoProducer.sendMessage("ToDo Added!");
    }
}
