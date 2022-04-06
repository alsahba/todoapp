package com.asb.todoapp.todo.producer.command;

import com.asb.todoapp.todo.entity.enumeration.Importance;
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
