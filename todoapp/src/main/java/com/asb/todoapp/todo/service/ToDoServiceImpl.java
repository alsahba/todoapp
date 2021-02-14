package com.asb.todoapp.todo.service;

import com.asb.todoapp.todo.entity.ToDo;
import com.asb.todoapp.todo.controller.dto.ToDoDetailDTO;
import com.asb.todoapp.todo.producer.AddToDoProducer;
import com.asb.todoapp.todo.producer.ToDoProducer;
import com.asb.todoapp.todo.producer.UpdateToDoProducer;
import com.asb.todoapp.todo.producer.pojo.AddToDoPojo;
import com.asb.todoapp.todo.producer.pojo.UpdateToDoPojo;
import com.asb.todoapp.todo.repository.ToDoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ToDoServiceImpl implements ToDoService {

    @Autowired
    private ToDoRepository toDoRepository;

    @Autowired
    private AddToDoProducer addToDoProducer;

    @Autowired
    private UpdateToDoProducer updateToDoProducer;

    @Override
    @Transactional(readOnly = true)
    public List<ToDoDetailDTO> getAll() {
        return toDoRepository.findAll().stream().map(ToDoDetailDTO::new).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void add(ToDo toDo) {
        toDoRepository.save(toDo);
    }

    @Override
    @Transactional
    public void update(ToDo toDo) {
        toDoRepository.save(toDo);
    }

    @Override
    @Transactional
    public void publishForAdd(AddToDoPojo addToDoPojo) {
        new ToDoProducer(addToDoProducer).publishMessage(addToDoPojo);
    }

    @Override
    @Transactional
    public void publishForUpdate(UpdateToDoPojo updateToDoPojo) {
        new ToDoProducer(updateToDoProducer).publishMessage(updateToDoPojo);
    }
}
