package com.asb.todoapp.todo.adapter.rest.controller;

import com.asb.todoapp.todo.adapter.rest.payload.AddToDoRequest;
import com.asb.todoapp.todo.adapter.rest.payload.ToDoResponse;
import com.asb.todoapp.todo.adapter.rest.payload.UpdateToDoRequest;
import com.asb.todoapp.todo.application.command.UpdateToDoCommand;
import com.asb.todoapp.todo.application.ToDoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Positive;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/todos")
@Slf4j
public class ToDoController {

    private final ToDoService toDoService;

    @GetMapping
    public ResponseEntity<List<ToDoResponse>> getAll() {
        return ResponseEntity.ok().body(toDoService.getAll().stream().map(ToDoResponse::new).toList());
    }

    @PostMapping
    public ResponseEntity add(@RequestBody @Valid AddToDoRequest addToDoRequest) {
        toDoService.publishForAdd(addToDoRequest.toCommand());
        return ResponseEntity.ok().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<String> update(@RequestBody @Valid UpdateToDoRequest updateToDoRequest,
                                         @PathVariable @Positive Long id) {
        toDoService.publishForUpdate(new UpdateToDoCommand(id, updateToDoRequest));
        return ResponseEntity.ok().build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> delete(@PathVariable @Positive Long id) {
        toDoService.publishForDelete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ToDoResponse> getDetail(@PathVariable @Positive Long id) {
        return ResponseEntity.ok().body(new ToDoResponse(toDoService.getDetail(id)));
    }
}
