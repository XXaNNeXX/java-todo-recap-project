package com.example.backend;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ToDoService {

    private ToDoRepo toDoRepo;


    public List<ToDo> findAllToDos() {
        return toDoRepo.findAll();
    }

    public Optional<ToDo> findToDoById(String id) {
        return toDoRepo.findById(id);
    }

    public ToDo addToDo(ToDo toDo) {
        return toDoRepo.save(toDo);
    }

    public ToDo updateToDo(String id, ToDo toDo) {
        if(!id.equals(toDo.id())) {
            throw new IllegalArgumentException("Das ToDo existiert nicht");
        }
        return toDoRepo.save(toDo);
    }

    public void removeToDo(String id) {
        toDoRepo.deleteById(id);
    }
}
