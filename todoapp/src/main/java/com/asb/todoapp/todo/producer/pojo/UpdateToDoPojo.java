package com.asb.todoapp.todo.producer.pojo;

import com.asb.todoapp.todo.entity.enumeration.Importance;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateToDoPojo extends ToDoPojo {

    private Long id;
    private String explanation;
    private Importance importance;

}
