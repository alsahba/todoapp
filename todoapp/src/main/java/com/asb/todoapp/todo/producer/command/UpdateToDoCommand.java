package com.asb.todoapp.todo.producer.command;

import com.asb.todoapp.todo.controller.dto.UpdateToDoRequest;
import com.asb.todoapp.todo.entity.enumeration.Importance;
import com.asb.todoapp.todo.entity.enumeration.Status;
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
