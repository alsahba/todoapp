package com.asb.todoapp.todo.application.port;

import com.asb.todoapp.todo.domain.ToDo;

import java.util.Collection;
import java.util.List;

public interface CrudTodoPort {

   ToDo save(ToDo todo);

   void update(ToDo toDo);

   ToDo loadById(Long id);

   void delete(Long id);

   List<ToDo> loadAll();
}
