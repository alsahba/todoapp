package com.asb.todoapp.todo.application.command;

import com.asb.todoapp.todo.adapter.rest.payload.UpdateToDoRequest;
import com.asb.todoapp.todo.domain.enumeration.Status;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
public class UpdateToDoCommand extends ToDoCommand {

    private Long id;
    private Status status;

    public UpdateToDoCommand(Long id, UpdateToDoRequest request) {
        super(request.getExplanation(), request.getImportance());
        this.id = id;
        this.status = request.getStatus();
    }
}
