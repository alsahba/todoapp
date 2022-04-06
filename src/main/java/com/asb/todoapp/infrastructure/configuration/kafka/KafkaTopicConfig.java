package com.asb.todoapp.infrastructure.configuration.kafka;

import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaAdmin;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaTopicConfig {

   @Value(value = "${kafka.bootstrapAddress}")
   private String bootstrapAddress;

   @Bean
   public KafkaAdmin kafkaAdmin() {
      Map<String, Object> configs = new HashMap<>();
      configs.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapAddress);
      return new KafkaAdmin(configs);
   }

   @Bean
   public NewTopic addToDoTopic() {
      return new NewTopic(Topic.ADD_TODO_TOPIC.getName(), 1, (short) 1);
   }

   @Bean
   public NewTopic updateToDoTopic() {
      return new NewTopic(Topic.UPDATE_TODO_TOPIC.getName(), 1, (short) 1);
   }

   @Bean
   public NewTopic deleteToDoTopic() {
      return new NewTopic(Topic.DELETE_TODO_TOPIC.getName(), 1, (short) 1);
   }

   @Bean
   public NewTopic addLogTopic() {
      return new NewTopic(Topic.ADD_LOG_TOPIC.getName(), 1, (short) 1);
   }
}
