package com.asb.todoapp.infrastructure.configuration.kafka;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Topic {

    ADD_TODO_TOPIC("add-todo-topic"),
    UPDATE_TODO_TOPIC("update-todo-topic"),
    DELETE_TODO_TOPIC("delete-todo-topic"),
    ADD_LOG_TOPIC("add-log-topic");

    private final String name;

}
