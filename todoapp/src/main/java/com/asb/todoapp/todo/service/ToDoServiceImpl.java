package com.asb.todoapp.todo.service;

import com.asb.todoapp.applog.entity.enumeration.Operation;
import com.asb.todoapp.todo.controller.dto.ToDoDetailDTO;
import com.asb.todoapp.todo.entity.ToDo;
import com.asb.todoapp.todo.entity.enumeration.Status;
import com.asb.todoapp.todo.producer.AddToDoProducer;
import com.asb.todoapp.todo.producer.DeleteToDoProducer;
import com.asb.todoapp.todo.producer.ToDoProducer;
import com.asb.todoapp.todo.producer.UpdateToDoProducer;
import com.asb.todoapp.todo.producer.pojo.AddToDoPojo;
import com.asb.todoapp.todo.producer.pojo.ToDoPojo;
import com.asb.todoapp.todo.producer.pojo.UpdateToDoPojo;
import com.asb.todoapp.todo.repository.ToDoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ToDoServiceImpl implements ToDoService {

    @Autowired
    private ToDoRepository toDoRepository;

    @Autowired
    private AddToDoProducer addToDoProducer;

    @Autowired
    private UpdateToDoProducer updateToDoProducer;

    @Autowired
    private DeleteToDoProducer deleteToDoProducer;

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
        Optional<ToDo> toDoFromDb = toDoRepository.findById(toDo.getId());
        toDoFromDb.ifPresent(data -> {
            data.setExplanation(toDo.getExplanation());
            data.setImportance(toDo.getImportance());
            toDoRepository.save(toDoFromDb.get());
        });
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

    @Override
    @Transactional
    public void publishForDelete(Long id) {
        deleteToDoProducer.publishMessage(id);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        Optional<ToDo> toDo = toDoRepository.findById(id);
        toDo.ifPresent(toDoFromDb -> {
            toDoFromDb.setStatus(Status.DELETED);
            toDoRepository.save(toDoFromDb);
        });
    }

    @Override
    @Transactional(readOnly = true)
    public ToDoDetailDTO getDetail(Long id) {
        return toDoRepository.findById(id).map(ToDoDetailDTO::new).orElseGet(ToDoDetailDTO::new);
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    private void addLog(Operation operation, Long id, ToDoPojo toDoPojo) {
        // TODO: 16.2.2021  
    }
}
