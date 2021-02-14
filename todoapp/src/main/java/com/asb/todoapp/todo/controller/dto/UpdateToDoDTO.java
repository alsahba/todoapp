package com.asb.todoapp.todo.controller.dto;

import com.asb.todoapp.todo.entity.enumeration.Importance;
import com.asb.todoapp.todo.producer.pojo.UpdateToDoPojo;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
public class UpdateToDoDTO {

    @NotNull(message = "Id may not be null")
    private Long id;

    @NotBlank(message = "Explanation may not be null or blank")
    private String explanation;

    @NotBlank(message = "Importance may not be null or blank")
    private String importance;

    public UpdateToDoPojo convertToPojo() {
        return new UpdateToDoPojo(id, explanation, Importance.valueOf(importance));
    }
}
