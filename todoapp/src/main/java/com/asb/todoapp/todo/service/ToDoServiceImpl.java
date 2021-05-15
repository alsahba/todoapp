package com.asb.todoapp.todo.service;

import com.asb.todoapp.todo.controller.dto.ToDoDetailDTO;
import com.asb.todoapp.todo.entity.ToDo;
import com.asb.todoapp.todo.entity.enumeration.Status;
import com.asb.todoapp.todo.producer.ToDoProducer;
import com.asb.todoapp.todo.producer.Topic;
import com.asb.todoapp.todo.producer.pojo.AddToDoPojo;
import com.asb.todoapp.todo.producer.pojo.UpdateToDoPojo;
import com.asb.todoapp.todo.repository.ToDoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ToDoServiceImpl implements ToDoService {

    private final ToDoRepository toDoRepository;
    private final ToDoProducer toDoProducer;

    public ToDoServiceImpl(ToDoRepository toDoRepository, ToDoProducer toDoProducer) {
        this.toDoRepository = toDoRepository;
        this.toDoProducer = toDoProducer;
    }

    @Override
    @Transactional(readOnly = true)
    public List<ToDoDetailDTO> getAll() {
        return toDoRepository.findAllByStatusIn(Status.getActiveStatusList())
                .stream().map(ToDoDetailDTO::new).collect(Collectors.toList());
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
        toDoProducer.publish(addToDoPojo, Topic.ADD_TODO_TOPIC);
    }

    @Override
    @Transactional
    public void publishForUpdate(UpdateToDoPojo updateToDoPojo) {
        toDoProducer.publish(updateToDoPojo, Topic.UPDATE_TODO_TOPIC);
    }

    @Override
    @Transactional
    public void publishForDelete(Long id) {
        toDoProducer.publish(id, Topic.DELETE_TODO_TOPIC);
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
}
