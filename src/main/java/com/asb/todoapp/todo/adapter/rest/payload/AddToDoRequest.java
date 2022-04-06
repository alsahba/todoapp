package com.asb.todoapp.todo.adapter.rest.payload;

import com.asb.todoapp.todo.domain.enumeration.Importance;
import com.asb.todoapp.todo.application.command.AddToDoCommand;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class AddToDoRequest {

    @NotBlank
    private String explanation;

    @NotNull
    private Importance importance;

    public AddToDoCommand toCommand() {
        return new AddToDoCommand(explanation, importance);
    }
}
