package com.asb.todoapp.todo.adapter.kafka.consumer;

import com.asb.todoapp.todo.application.ToDoService;
import com.asb.todoapp.todo.domain.ToDo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class ToDoConsumer {

    private final ToDoService toDoService;

    @KafkaListener(topics = "add-todo-topic", groupId = "todo", containerFactory = "objectContainerFactory")
    public void listenForSave(ToDo toDo) {
        toDoService.add(toDo);
        log.info("Received todo for add operation");
    }

    @KafkaListener(topics = "update-todo-topic", groupId = "todo", containerFactory = "objectContainerFactory")
    public void listenForUpdate(ToDo toDo) {
        toDoService.update(toDo);
        log.info("Received todo for update operation, id: " + toDo.getId());
    }

    @KafkaListener(topics = "delete-todo-topic", groupId = "todo", containerFactory = "objectContainerFactory")
    public void listenForDelete(Long id) {
        toDoService.delete(id);
        log.info("Received todo for delete operation, id: " + id);
    }
}
