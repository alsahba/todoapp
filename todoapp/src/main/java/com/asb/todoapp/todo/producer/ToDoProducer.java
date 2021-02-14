package com.asb.todoapp.todo.producer;

import com.asb.todoapp.todo.entity.enumeration.Importance;
import com.asb.todoapp.todo.producer.pojo.AddToDoPojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class ToDoProducer {

    @Autowired
    @Qualifier(value = "objectTemplate")
    private KafkaTemplate<String, Object> kafkaTemplate;

    public void sendMessage(String msg) {
        AddToDoPojo toDoPojo = new AddToDoPojo("SAMPLE EXP", Importance.URGENT);
        kafkaTemplate.send("addTodoTopic", toDoPojo);
    }
}
