package com.asb.todoapp.todo.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import java.util.UUID;

@Service
public class ToDoProducer {

    @Autowired
    @Qualifier(value = "objectTemplate")
    private KafkaTemplate<String, Object> kafkaTemplate;

    private Logger logger = LoggerFactory.getLogger(ToDoProducer.class);

    public void publish(Object obj, Topic topic) {
        ListenableFuture<SendResult<String, Object>> future = kafkaTemplate.send(topic.getValue(), UUID.randomUUID().toString(), obj);
        future.addCallback(new ListenableFutureCallback<SendResult<String, Object>>() {
            @Override
            public void onSuccess(final SendResult<String, Object> message) {
                logger.info("sent message= " + message.toString() + " with offset= " + message.getRecordMetadata().offset());
            }

            @Override
            public void onFailure(final Throwable throwable) {
                logger.error("unable to send message= ", throwable);
            }
        });
    }
}
