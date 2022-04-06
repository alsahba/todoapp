package com.asb.todoapp.todo.adapter.persistence;

import com.asb.todoapp.todo.domain.ToDo;
import com.asb.todoapp.todo.domain.enumeration.Status;
import com.asb.todoapp.todo.domain.enumeration.Importance;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "todo")
@Getter
@Setter
@NoArgsConstructor
class ToDoEntity {

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

    public ToDoEntity(ToDo toDo) {
        setExplanation(toDo.getExplanation());
        setId(toDo.getId());
        setImportance(toDo.getImportance());
        setStatus(toDo.getStatus());
    }

    public ToDo toDomain() {
        return new ToDo(id, explanation, importance, status);
    }

}
