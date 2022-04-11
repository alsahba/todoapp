package com.asb.todoapp.todo.application;

import com.asb.todoapp.todo.application.port.CrudTodoPort;
import com.asb.todoapp.todo.application.port.PublishTodoPort;
import com.asb.todoapp.todo.domain.ToDo;
import com.asb.todoapp.todo.application.command.AddToDoCommand;
import com.asb.todoapp.todo.application.command.UpdateToDoCommand;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class ToDoService {

   private final CrudTodoPort crudTodoPort;
   private final PublishTodoPort publishTodoPort;

   public List<ToDo> getAll() {
      return crudTodoPort.loadAll();
   }

   public void add(ToDo toDo) {
      crudTodoPort.save(toDo);
   }

   public void update(ToDo toDo) {
      crudTodoPort.update(toDo);
   }

   public void delete(Long id) {
      crudTodoPort.delete(id);
   }

   public void publishForAdd(AddToDoCommand command) {
      publishTodoPort.publishForSave(new ToDo(command));
   }

   public void publishForUpdate(UpdateToDoCommand command) {
      publishTodoPort.publishForUpdate(new ToDo(command));
   }

   public void publishForDelete(Long id) {
      publishTodoPort.publishForDelete(id);
   }

   public ToDo getDetail(Long id) {
      return crudTodoPort.loadById(id);
   }

}
