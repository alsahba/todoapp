package com.asb.todoapp.todo.controller.dto;

import com.asb.todoapp.todo.entity.enumeration.Importance;
import com.asb.todoapp.todo.producer.pojo.AddToDoPojo;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
public class AddToDoDTO {

    @NotBlank(message = "Explanation may not be null or blank")
    private String explanation;

    @NotBlank(message = "Importance may not be null or blank")
    private String importance;

    public AddToDoPojo convertToPojo() {
        return new AddToDoPojo(getExplanation(), Importance.valueOf(getImportance()));
    }
}
