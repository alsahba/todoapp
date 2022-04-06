package com.asb.todoapp.todo.adapter.persistence;

import com.asb.todoapp.todo.application.port.CrudTodoPort;
import com.asb.todoapp.todo.domain.ToDo;
import com.asb.todoapp.todo.domain.enumeration.Status;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class TodoPersistenceAdapter implements CrudTodoPort {

   private final ToDoRepository toDoRepository;
   @Override
   public ToDo save(ToDo todo) {
      return toDoRepository.save(new ToDoEntity(todo)).toDomain();
   }

   @Override
   public void update(ToDo toDo) {
      var entity = findById(toDo.getId());
      entity.setStatus(toDo.getStatus());
      entity.setImportance(toDo.getImportance());
      entity.setExplanation(toDo.getExplanation());
      toDoRepository.save(entity);
   }

   @Override
   public ToDo loadById(Long id) {
      return findById(id).toDomain();
   }

   @Override
   public void delete(Long id) {
      toDoRepository.deleteById(id);
   }

   @Override
   public List<ToDo> loadAll() {
      return toDoRepository.findAllByStatusIn(Status.getActiveStatusList()).stream()
          .map(ToDoEntity::toDomain)
          .toList();
   }

   private ToDoEntity findById(Long id) {
      return toDoRepository.findById(id).orElseThrow(() -> new RuntimeException("Not found"));
   }
}
