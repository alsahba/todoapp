package com.asb.todoapp.todo.producer.pojo;

import com.asb.todoapp.todo.entity.enumeration.Importance;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UpdateToDoPojo extends ToDoPojo {

    private Long id;

    public UpdateToDoPojo(Long id, String explanation, Importance importance) {
        super(explanation, importance);
        this.id = id;
    }
}
