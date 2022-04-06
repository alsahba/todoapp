package com.asb.todoapp.todo.application.port;

import com.asb.todoapp.todo.domain.ToDo;

public interface PublishTodoPort {

   void publishForSave(ToDo todo);
   void publishForUpdate(ToDo todo);
   void publishForDelete(Long id);

}
