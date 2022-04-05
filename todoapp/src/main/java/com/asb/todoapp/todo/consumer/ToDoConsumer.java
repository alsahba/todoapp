package com.asb.todoapp.todo.consumer;

import com.asb.todoapp.todo.entity.ToDo;
import com.asb.todoapp.todo.producer.command.AddToDoCommand;
import com.asb.todoapp.todo.producer.command.UpdateToDoCommand;
import com.asb.todoapp.todo.service.ToDoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class ToDoConsumer {

    private final ToDoService toDoService;

    @KafkaListener(topics = "add-todo-topic", groupId = "todo", containerFactory = "objectContainerFactory")
    public void listen(AddToDoCommand addToDoCommand) {
        toDoService.add(new ToDo(addToDoCommand));
        log.info("Received todo for add operation");
    }

    @KafkaListener(topics = "update-todo-topic", groupId = "todo", containerFactory = "objectContainerFactory")
    public void listen(UpdateToDoCommand updateToDoPojo) {
        toDoService.update(new ToDo(updateToDoPojo));
        log.info("Received todo for update operation, id: " + updateToDoPojo.getId());
    }

    @KafkaListener(topics = "delete-todo-topic", groupId = "todo", containerFactory = "objectContainerFactory")
    public void listen(Long id) {
        toDoService.deleteById(id);
        log.info("Received todo for delete operation, id: " + id);
    }
}
