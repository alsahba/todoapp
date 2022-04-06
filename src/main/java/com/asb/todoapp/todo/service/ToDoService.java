package com.asb.todoapp.todo.service;

import com.asb.todoapp.todo.controller.dto.ToDoDetailResponse;
import com.asb.todoapp.todo.entity.ToDo;
import com.asb.todoapp.todo.entity.enumeration.Status;
import com.asb.todoapp.todo.producer.ToDoProducer;
import com.asb.todoapp.infrastructure.configuration.kafka.Topic;
import com.asb.todoapp.todo.producer.command.AddToDoCommand;
import com.asb.todoapp.todo.producer.command.UpdateToDoCommand;
import com.asb.todoapp.todo.repository.ToDoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class ToDoService {

   private final ToDoRepository toDoRepository;
   private final ToDoProducer toDoProducer;

   public List<ToDoDetailResponse> getAll() {
      return toDoRepository.findAllByStatusIn(Status.getActiveStatusList())
          .stream().map(ToDoDetailResponse::new).collect(Collectors.toList());
   }

   public void add(ToDo toDo) {
      toDoRepository.save(toDo);
   }

   public void update(ToDo toDo) {
      ToDo toDoDb = findById(toDo.getId());
      toDoDb.setExplanation(toDo.getExplanation());
      toDoDb.setImportance(toDo.getImportance());
      toDoDb.setStatus(toDo.getStatus());
      toDoRepository.save(toDoDb);
   }

   public void publishForAdd(AddToDoCommand addToDoCommand) {
      toDoProducer.publish(addToDoCommand, Topic.ADD_TODO_TOPIC);
   }

   public void publishForUpdate(UpdateToDoCommand updateToDoPojo) {
      toDoProducer.publish(updateToDoPojo, Topic.UPDATE_TODO_TOPIC);
   }

   public void publishForDelete(Long id) {
      toDoProducer.publish(id, Topic.DELETE_TODO_TOPIC);
   }

   public void deleteById(Long id) {
      ToDo todo = findById(id);
      todo.setStatus(Status.DELETED);
      toDoRepository.save(todo);
   }

   public ToDoDetailResponse getDetail(Long id) {
      return new ToDoDetailResponse(findById(id));
   }

   private ToDo findById(Long id) {
      return toDoRepository.findById(id).orElseThrow(() -> new RuntimeException("ToDo not found"));
   }
}
