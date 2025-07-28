package com.ryu.todo.controller;

import com.ryu.todo.dto.TodoRequestDTO;
import com.ryu.todo.dto.TodoResponseDTO;
import com.ryu.todo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todos")
public class TodoController {

    @Autowired
    private TodoService todoService;

    @GetMapping
    public List<TodoResponseDTO> getTodos() {
        return todoService.getAllTodos();
    }

    @PostMapping
    public TodoResponseDTO createTodo(@RequestBody TodoRequestDTO dto) {
        return todoService.createTodo(dto);
    }

    @PutMapping("/{id}")
    public TodoResponseDTO updateTodo(@PathVariable Long id, @RequestBody TodoRequestDTO dto) {
        return todoService.updateTodo(id, dto);
    }

    @DeleteMapping("/{id}")
    public void deleteTodo(@PathVariable Long id) {
        todoService.deleteTodo(id);
    }
}
