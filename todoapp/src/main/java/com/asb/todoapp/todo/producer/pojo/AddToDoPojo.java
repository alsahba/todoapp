package com.asb.todoapp.todo.producer.pojo;

import com.asb.todoapp.todo.entity.enumeration.Importance;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AddToDoPojo {

    private Long id;
    private String explanation;
    private Importance importance;

    public AddToDoPojo(String explanation, Importance importance) {
        this.explanation = explanation;
        this.importance = importance;
    }
}
