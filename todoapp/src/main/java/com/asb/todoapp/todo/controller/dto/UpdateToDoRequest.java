package com.asb.todoapp.todo.controller.dto;

import com.asb.todoapp.todo.entity.enumeration.Importance;
import com.asb.todoapp.todo.entity.enumeration.Status;
import com.asb.todoapp.todo.producer.command.UpdateToDoCommand;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
public class UpdateToDoRequest {

    @NotNull
    private Long id;

    @NotBlank
    private String explanation;

    @NotBlank
    private Importance importance;

    @NotNull
    private Status status;

    public UpdateToDoCommand toCommand() {
        return new UpdateToDoCommand(id, explanation, importance, status);
    }
}
