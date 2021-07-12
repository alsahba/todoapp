package com.asb.todoapp.todo.producer.pojo;

import com.asb.todoapp.todo.entity.enumeration.Importance;
import lombok.*;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class AddToDoPojo extends ToDoPojo {

    public AddToDoPojo(String explanation, Importance importance) {
        super.setExplanation(explanation);
        super.setImportance(importance);
    }
}
