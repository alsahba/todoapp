package com.asb.todoapp.todo.entity;

import com.asb.todoapp.todo.entity.enumeration.Importance;
import com.asb.todoapp.todo.entity.enumeration.Status;
import com.asb.todoapp.todo.producer.command.AddToDoCommand;
import com.asb.todoapp.todo.producer.command.UpdateToDoCommand;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class ToDo {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    private String explanation;

    private Importance importance;

    @CreatedDate
    private LocalDateTime creationDate;

    @LastModifiedDate
    private LocalDateTime lastModifiedDate;

    private Status status;

    public ToDo(AddToDoCommand addToDoCommand) {
        this.explanation = addToDoCommand.getExplanation();
        this.importance = addToDoCommand.getImportance();
        this.status = Status.CREATED;
    }

    public ToDo(UpdateToDoCommand updateToDoPojo) {
        this.id = updateToDoPojo.getId();
        this.explanation = updateToDoPojo.getExplanation();
        this.importance = updateToDoPojo.getImportance();
        this.status = updateToDoPojo.getStatus();
    }
}
