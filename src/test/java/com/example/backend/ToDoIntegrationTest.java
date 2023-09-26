package com.example.backend;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ToDoIntegrationTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ToDoRepo toDoRepo;

    @Test
    @DirtiesContext
    void getAllToDosTest() throws Exception {
        toDoRepo.save(new ToDo("1", "gassi gehen", "OPEN"));

        mockMvc.perform(MockMvcRequestBuilders.get("/api/todo"))
                .andExpect(status().isOk())
                .andExpect(content().json("""
                        [
                        {
                            "id": "1",
                            "description": "gassi gehen",
                            "status": "OPEN"
                        }
                        ]
                        """));
    }

    @Test
    @DirtiesContext
    void getToDoByIdTest() throws Exception {
        toDoRepo.save(new ToDo("1", "gassi gehen", "OPEN"));

        mockMvc.perform(MockMvcRequestBuilders.get("/api/todo/1"))
                .andExpect(status().isOk())
                .andExpect(content().json("""
                        {
                            "id": "1",
                            "description": "gassi gehen",
                            "status": "OPEN"
                        }
                        """));
    }

    @Test
    @DirtiesContext
    void addToDoTest() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.post("/api/todo")
                .contentType(MediaType.APPLICATION_JSON)
                .content("""
                        {
                            "id": "1",
                            "description": "gassi gehen",
                            "status": "OPEN"
                        }
                        """))
                .andExpect(status().isOk())
                .andExpect(content().json("""
                        {
                            "id": "1",
                            "description": "gassi gehen",
                            "status": "OPEN"
                        }
                        """));
    }
}
