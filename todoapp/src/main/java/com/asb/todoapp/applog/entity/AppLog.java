package com.asb.todoapp.applog.entity;

import com.asb.todoapp.applog.entity.enumeration.Operation;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Entity
@Table(name = "APPLOG")
public class AppLog {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @Column(name = "TIMESTAMP")
    private LocalDateTime timestamp;

    @Column(name = "OPERATION")
    @Enumerated(EnumType.STRING)
    private Operation operation;

    @Column(name = "DESCRIPTION")
    private String description;

    // User information
}
