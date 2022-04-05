package com.asb.todoapp.todo.controller.dto;

import com.asb.todoapp.todo.entity.ToDo;
import com.asb.todoapp.todo.entity.enumeration.Importance;
import com.asb.todoapp.todo.entity.enumeration.Status;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Getter
public class ToDoDetailResponse {

    private final Long id;
    private final String explanation;
    private final Importance importance;
    private final Status status;

    public ToDoDetailResponse(ToDo toDo) {
        this.id = toDo.getId();
        this.explanation = toDo.getExplanation();
        this.importance = toDo.getImportance();
        this.status = toDo.getStatus();
    }
}
