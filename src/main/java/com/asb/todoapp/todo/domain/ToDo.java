package com.asb.todoapp.todo.domain;

import com.asb.todoapp.todo.application.command.AddToDoCommand;
import com.asb.todoapp.todo.application.command.UpdateToDoCommand;
import com.asb.todoapp.todo.domain.enumeration.Importance;
import com.asb.todoapp.todo.domain.enumeration.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ToDo {

   private Long id;
   private String explanation;
   private Importance importance;
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
