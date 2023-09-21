package com.example.backend;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ToDoService {

    private ToDoRepo toDoRepo;

    public ToDoService(ToDoRepo toDoRepo) {
        this.toDoRepo = toDoRepo;
    }

    public List<ToDo> findAllToDos() {
        return toDoRepo.findAll();
    }

    public Optional<ToDo> findToDoById(String id) {
        return toDoRepo.findById(id);
    }

    public ToDo addToDo(ToDo toDo) {
        return toDoRepo.save(toDo);
    }

    public ToDo updateToDo(ToDo toDo) {
        return toDoRepo.save(toDo);
    }

    public void removeToDo(String id) {
        toDoRepo.deleteById(id);
    }
}
