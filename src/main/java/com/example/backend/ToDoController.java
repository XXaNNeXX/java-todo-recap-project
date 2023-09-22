package com.example.backend;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/todo")
@AllArgsConstructor
public class ToDoController {

    private ToDoService toDoService;


    @GetMapping
    public List<ToDo> getAllToDos() {
        return toDoService.findAllToDos();
    }

    @GetMapping("/{id}")
    public Optional<ToDo> getToDoById(@PathVariable String id) {
        return toDoService.findToDoById(id);
    }

    @PostMapping
    public ToDo postToDo(@RequestBody ToDo toDo) {
        return toDoService.addToDo(toDo);
    }

    @PutMapping("/{id}")
    public ToDo putToDo(@PathVariable String id, @RequestBody ToDo toDo) {
        return toDoService.updateToDo(id, toDo);
    }

    @DeleteMapping("/{id}")
    public void deleteToDo(@PathVariable String id) {
        toDoService.removeToDo(id);
    }
}
