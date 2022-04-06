package com.asb.todoapp.todo.adapter.rest.payload;

import com.asb.todoapp.todo.domain.ToDo;
import com.asb.todoapp.todo.domain.enumeration.Importance;
import com.asb.todoapp.todo.domain.enumeration.Status;
import lombok.Getter;

@Getter
public class ToDoResponse {

    private final Long id;
    private final String explanation;
    private final Importance importance;
    private final Status status;

    public ToDoResponse(ToDo toDo) {
        this.id = toDo.getId();
        this.explanation = toDo.getExplanation();
        this.importance = toDo.getImportance();
        this.status = toDo.getStatus();
    }
}
