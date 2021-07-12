package com.asb.todoapp.todo.controller;

import com.asb.todoapp.todo.controller.dto.AddToDoDTO;
import com.asb.todoapp.todo.controller.dto.ToDoDetailDTO;
import com.asb.todoapp.todo.controller.dto.UpdateToDoDTO;
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
@RequestMapping(value = "/todo")
public class ToDoController {

    private final ToDoService toDoService;

    @GetMapping()
    public ResponseEntity<List<ToDoDetailDTO>> getAll() {
        return ResponseEntity.ok(toDoService.getAll());
    }

    @PostMapping()
    public ResponseEntity<String> add(@RequestBody @Valid AddToDoDTO addToDoDTO) {
        toDoService.publishForAdd(addToDoDTO.convertToPojo());
        return new ResponseEntity<>("ToDo Added Successfully!", HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<String> update(@RequestBody @Valid UpdateToDoDTO updateToDoDTO) {
        toDoService.publishForUpdate(updateToDoDTO.convertToPojo());
        return new ResponseEntity<>("ToDo Updated Successfully!", HttpStatus.ACCEPTED);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> delete(@PathVariable @Min(1) Long id) {
        toDoService.publishForDelete(id);
        return new ResponseEntity<>("ToDo Deleted Successfully!", HttpStatus.ACCEPTED);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ToDoDetailDTO> getDetail(@PathVariable @Min(1) Long id) {
        return ResponseEntity.ok(toDoService.getDetail(id));
    }
}
