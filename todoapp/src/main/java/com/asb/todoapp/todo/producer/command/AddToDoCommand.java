package com.asb.todoapp.todo.producer.command;

import com.asb.todoapp.todo.entity.enumeration.Importance;
import lombok.*;

@Getter
public class AddToDoCommand extends ToDoCommand {

    public AddToDoCommand(String explanation, Importance importance) {
        super(explanation, importance);
    }
}
