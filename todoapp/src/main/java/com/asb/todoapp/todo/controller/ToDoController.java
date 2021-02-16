package com.asb.todoapp.todo.controller;

import com.asb.todoapp.todo.controller.dto.AddToDoDTO;
import com.asb.todoapp.todo.controller.dto.ToDoDetailDTO;
import com.asb.todoapp.todo.controller.dto.UpdateToDoDTO;
import com.asb.todoapp.todo.service.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todo")
public class ToDoController {

    @Autowired
    private ToDoService toDoService;

    @GetMapping("/all")
    public List<ToDoDetailDTO> getAll() {
        return toDoService.getAll();
    }

    @PostMapping("/add")
    public String add(@RequestBody AddToDoDTO addToDoDTO) {
        toDoService.publishForAdd(addToDoDTO.convertToPojo());
        return "ToDo added successfully";
    }

    @PostMapping("/update")
    public String update(@RequestBody UpdateToDoDTO updateToDoDTO) {
        toDoService.publishForUpdate(updateToDoDTO.convertToPojo());
        return "ToDo updated successfully";
    }

    @DeleteMapping(value = "/delete/{id}")
    public String delete(@PathVariable Long id) {
        toDoService.publishForDelete(id);
        return "ToDo deleted successfully";
    }

    @GetMapping(value = "{id}")
    public ToDoDetailDTO getDetail(@PathVariable Long id) {
        return toDoService.getDetail(id);
    }
}
