package com.asb.todoapp.todo.repository;

import com.asb.todoapp.todo.entity.ToDo;
import com.asb.todoapp.todo.entity.enumeration.Status;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ToDoRepository extends JpaRepository<ToDo, Long> {
    List<ToDo> findAllByStatusIn(List<Status> statusList);
}
