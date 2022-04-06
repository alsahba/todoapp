package com.asb.todoapp.todo.application.command;

import com.asb.todoapp.todo.domain.enumeration.Importance;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ToDoCommand {

    private String explanation;
    private Importance importance;

}
