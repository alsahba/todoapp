package com.asb.todoapp.todo.consumer;

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

    @KafkaListener(topics = "baeldung2")
    public void listen(String message) {
        toDoService.add();
        logger.error("Received Message in group todo: " + message);
    }
}
