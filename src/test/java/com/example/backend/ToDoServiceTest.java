package com.example.backend;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class ToDoServiceTest {

    ToDoRepo toDoRepo = mock(ToDoRepo.class);
    ToDoService toDoService = new ToDoService(toDoRepo);

    @Test
    void findAllToDos_returnList() {

        ToDo todo1 = new ToDo("1", "gassi gehen", "OPEN");
        ToDo todo2 = new ToDo("2", "einkaufen", "OPEN");
        List<ToDo> toDoList = List.of(todo1, todo2);

        when(toDoRepo.findAll()).thenReturn(toDoList);
        List<ToDo> actual = toDoService.findAllToDos();
        List<ToDo> expected = List.of(todo1, todo2);

        verify(toDoRepo).findAll();
        assertEquals(expected, actual);
    }
    @Test
    void findToDoById_returnOptionalToDo() {

        String id = "1";
        ToDo todo1 = new ToDo("1", "gassi gehen", "OPEN");

        when(toDoRepo.findById(id)).thenReturn(Optional.of(todo1));
        Optional<ToDo> actual = toDoService.findToDoById(id);
        Optional<ToDo> expected = Optional.of(new ToDo("1", "gassi gehen", "OPEN"));

        verify(toDoRepo).findById(id);
        assertEquals(expected, actual);
    }

    @Test
    void addToDo_returnToDo() {

        ToDo todo1 = new ToDo("1", "gassi gehen", "OPEN");

        when(toDoRepo.save(todo1)).thenReturn(todo1);
        ToDo actual = toDoService.addToDo(todo1);
        ToDo expected = new ToDo("1", "gassi gehen", "OPEN");

        verify(toDoRepo).save(todo1);
        assertEquals(expected, actual);
    }


}
