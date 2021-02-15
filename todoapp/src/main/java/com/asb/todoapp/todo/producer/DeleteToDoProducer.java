package com.asb.todoapp.todo.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class DeleteToDoProducer {

    @Autowired
    @Qualifier(value = "objectTemplate")
    private KafkaTemplate<String, Object> kafkaTemplate;

    public void publishMessage(Long id) {
        kafkaTemplate.send("deleteTodoTopic", id);
    }
}
