package com.asb.todoapp.todo.adapter.kafka.producer;

import com.asb.todoapp.infrastructure.configuration.kafka.Topic;
import com.asb.todoapp.todo.application.port.PublishTodoPort;
import com.asb.todoapp.todo.domain.ToDo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Service
@Slf4j
public class ToDoProducer implements PublishTodoPort {

   private final KafkaTemplate<String, Object> kafkaTemplate;

   public ToDoProducer(@Qualifier(value = "objectTemplate") KafkaTemplate<String, Object> kafkaTemplate) {
      this.kafkaTemplate = kafkaTemplate;
   }

   @Override
   public void publishForSave(ToDo todo) {
      publish(todo, Topic.ADD_TODO_TOPIC);
   }

   @Override
   public void publishForUpdate(ToDo todo) {
      publish(todo, Topic.UPDATE_TODO_TOPIC);
   }

   @Override
   public void publishForDelete(Long id) {
      publish(id, Topic.DELETE_TODO_TOPIC);
   }

   private void publish(Object message, Topic topic) {
      try {
         log.info("Publishing message to topic: {}", topic.getName());
         kafkaTemplate.send(topic.getName(), UUID.randomUUID().toString(), message).get(60, TimeUnit.SECONDS);
      } catch (Exception e) {
         e.printStackTrace();
      }
   }
}
