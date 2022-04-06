package com.asb.todoapp.todo.adapter.rest.payload;

import com.asb.todoapp.todo.domain.enumeration.Importance;
import com.asb.todoapp.todo.domain.enumeration.Status;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
public class UpdateToDoRequest {

    @NotBlank
    private String explanation;

    @NotNull
    private Importance importance;

    @NotNull
    private Status status;

}
