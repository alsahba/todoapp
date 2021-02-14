package com.asb.todoapp.todo.producer;

import com.asb.todoapp.todo.producer.pojo.ToDoPojo;

public interface PublishStrategy {
    void publishMessage(ToDoPojo toDoPojo);
}
