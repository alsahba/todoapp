package com.asb.todoapp.todo.producer;

import com.asb.todoapp.todo.producer.pojo.ToDoPojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class AddToDoProducer implements PublishStrategy {

    @Autowired
    @Qualifier(value = "objectTemplate")
    private KafkaTemplate<String, Object> kafkaTemplate;

    @Override
    public void publishMessage(ToDoPojo toDoPojo) {
        kafkaTemplate.send("addTodoTopic", toDoPojo);
    }
}
