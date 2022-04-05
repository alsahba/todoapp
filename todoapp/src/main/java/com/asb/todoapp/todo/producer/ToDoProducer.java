package com.asb.todoapp.todo.producer;

import com.asb.todoapp.infrastructure.configuration.kafka.Topic;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Service
public class ToDoProducer {

   private final KafkaTemplate<String, Object> kafkaTemplate;

   public ToDoProducer(@Qualifier(value = "objectTemplate") KafkaTemplate<String, Object> kafkaTemplate) {
      this.kafkaTemplate = kafkaTemplate;
   }

   public void publish(Object message, Topic topic) {
      try {
         kafkaTemplate.send(topic.name(), UUID.randomUUID().toString(), message).get(60, TimeUnit.SECONDS);
      } catch (Exception e) {
         e.printStackTrace();
      }
   }
}
