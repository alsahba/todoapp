package com.asb.todoapp.todo.application.command;

import com.asb.todoapp.todo.domain.enumeration.Importance;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
public class AddToDoCommand extends ToDoCommand {

    public AddToDoCommand(String explanation, Importance importance) {
        super(explanation, importance);
    }

}
