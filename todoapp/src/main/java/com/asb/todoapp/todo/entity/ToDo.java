package com.asb.todoapp.todo.entity;

import com.asb.todoapp.todo.entity.enumeration.Importance;
import com.asb.todoapp.todo.producer.pojo.AddToDoPojo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "TODO")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ToDo {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @Column(name = "EXPLANATION")
    private String explanation;

    @Column(name = "IMPORTANCE")
    @Enumerated(EnumType.STRING)
    private Importance importance;

    @Column(name = "CREATION_DATE")
    private LocalDateTime creationDate;

    public ToDo(AddToDoPojo addToDoPojo) {
        this.explanation = addToDoPojo.getExplanation();
        this.creationDate = LocalDateTime.now();
        this.importance = addToDoPojo.getImportance();
    }
}
