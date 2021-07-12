package com.asb.todoapp.todo.producer.pojo;

import com.asb.todoapp.todo.entity.enumeration.Importance;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class UpdateToDoPojo extends ToDoPojo {

    private Long id;

    public UpdateToDoPojo(Long id, String explanation, Importance importance) {
        super(explanation, importance);
        setId(id);
    }
}
