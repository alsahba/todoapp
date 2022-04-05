package com.asb.todoapp.todo.producer.command;

import com.asb.todoapp.todo.entity.enumeration.Importance;
import com.asb.todoapp.todo.entity.enumeration.Status;
import lombok.*;

@Getter
@RequiredArgsConstructor
public class UpdateToDoCommand extends ToDoCommand {

    private final Long id;
    private final Status status;

    public UpdateToDoCommand(Long id, String explanation, Importance importance, Status status) {
        super(explanation, importance);
        this.id = id;
        this.status = status;
    }
}
