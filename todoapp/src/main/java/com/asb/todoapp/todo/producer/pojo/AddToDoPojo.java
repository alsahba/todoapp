package com.asb.todoapp.todo.producer.pojo;

import com.asb.todoapp.todo.entity.enumeration.Importance;
import lombok.*;

@Data
@NoArgsConstructor
public class AddToDoPojo extends ToDoPojo {

    private Long id;
    private String explanation;
    private Importance importance;

    public AddToDoPojo(String explanation, Importance importance) {
        this.explanation = explanation;
        this.importance = importance;
    }
}
