package com.asb.todoapp.todo.producer;

import com.asb.todoapp.todo.producer.pojo.ToDoPojo;

public class ToDoProducer {

    private PublishStrategy publishStrategy;

    public ToDoProducer(PublishStrategy publishStrategy){
        this.publishStrategy = publishStrategy;
    }

    public void publishMessage(ToDoPojo toDoPojo) {
        publishStrategy.publishMessage(toDoPojo);
    }
}
