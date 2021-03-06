package com.asb.todoapp.todo.controller.dto;

import com.asb.todoapp.todo.entity.ToDo;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ToDoDetailDTO {

    private Long id;
    private String explanation;
    private String importance;
    private String status;

    public ToDoDetailDTO(ToDo toDo) {
        this.id = toDo.getId();
        this.explanation = toDo.getExplanation();
        this.importance = toDo.getImportance().toString();
        this.status = toDo.getStatus().toString();
    }
}
