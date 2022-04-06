package com.asb.todoapp.todo.adapter.persistence;

import com.asb.todoapp.todo.domain.enumeration.Status;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

interface ToDoRepository extends JpaRepository<ToDoEntity, Long> {
    List<ToDoEntity> findAllByStatusIn(List<Status> statusList);

}
