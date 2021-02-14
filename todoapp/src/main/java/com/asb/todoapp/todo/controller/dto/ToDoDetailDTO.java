package com.asb.todoapp.todo.controller.dto;

import com.asb.todoapp.todo.entity.ToDo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ToDoDetailDTO {

    private Long id;
    private String explanation;

    public ToDoDetailDTO(ToDo toDo) {
        this.id = toDo.getId();
        this.explanation = toDo.getExplanation();
    }
}
