package com.asb.todoapp.todo.producer;

public enum Topic {

    ADD_TODO_TOPIC("add-todo-topic"),
    UPDATE_TODO_TOPIC("update-todo-topic"),
    DELETE_TODO_TOPIC("delete-todo-topic"),
    ADD_LOG_TOPIC("add-log-topic");

    private String value;

    Topic(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
