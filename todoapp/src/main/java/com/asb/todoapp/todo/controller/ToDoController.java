package com.asb.todoapp.todo.controller;

import com.asb.todoapp.todo.controller.dto.AddToDoRequest;
import com.asb.todoapp.todo.controller.dto.ToDoDetailResponse;
import com.asb.todoapp.todo.controller.dto.UpdateToDoRequest;
import com.asb.todoapp.todo.service.ToDoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/todos")
public class ToDoController {

    private final ToDoService toDoService;

    @GetMapping
    public ResponseEntity<List<ToDoDetailResponse>> getAll() {
        return ResponseEntity.ok(toDoService.getAll());
    }

    @PostMapping
    public ResponseEntity<String> add(@RequestBody @Valid AddToDoRequest addToDoRequest) {
        toDoService.publishForAdd(addToDoRequest.toCommand());
        return new ResponseEntity<>("ToDo Added Successfully!", HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<String> update(@RequestBody @Valid UpdateToDoRequest updateToDoRequest) {
        toDoService.publishForUpdate(updateToDoRequest.toCommand());
        return new ResponseEntity<>("ToDo Updated Successfully!", HttpStatus.ACCEPTED);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> delete(@PathVariable @Min(1) Long id) {
        toDoService.publishForDelete(id);
        return new ResponseEntity<>("ToDo Deleted Successfully!", HttpStatus.ACCEPTED);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ToDoDetailResponse> getDetail(@PathVariable @Min(1) Long id) {
        return ResponseEntity.ok(toDoService.getDetail(id));
    }
}
