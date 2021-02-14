package com.asb.todoapp.todo.consumer;

import com.asb.todoapp.todo.entity.ToDo;
import com.asb.todoapp.todo.producer.pojo.AddToDoPojo;
import com.asb.todoapp.todo.producer.pojo.UpdateToDoPojo;
import com.asb.todoapp.todo.service.ToDoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class ToDoConsumer {

    @Autowired
    private ToDoService toDoService;

    private Logger logger = LoggerFactory.getLogger(ToDoConsumer.class);

    @KafkaListener(topics = "addTodoTopic", groupId = "todo", containerFactory = "objectContainerFactory")
    public void listen(AddToDoPojo addToDoPojo) {
        toDoService.add(new ToDo(addToDoPojo));
        logger.info("Received todo for add operation: " + addToDoPojo.getExplanation());
    }

    @KafkaListener(topics = "updateTodoTopic", groupId = "todo", containerFactory = "objectContainerFactory")
    public void listen(UpdateToDoPojo updateToDoPojo) {
        toDoService.update(new ToDo(updateToDoPojo));
        logger.info("Received todo for update operation: " + updateToDoPojo.getExplanation());
    }
}
