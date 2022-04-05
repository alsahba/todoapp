package com.asb.todoapp.todo.producer.command;

import com.asb.todoapp.todo.entity.enumeration.Importance;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ToDoCommand {

    private final String explanation;
    private final Importance importance;

}
