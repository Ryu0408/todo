package com.ryu.todo.service;

import com.ryu.todo.dto.TodoRequestDTO;
import com.ryu.todo.dto.TodoResponseDTO;
import com.ryu.todo.entity.Todo;
import com.ryu.todo.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TodoService {

    @Autowired
    private TodoRepository todoRepository;

    // 전체 목록
    public List<TodoResponseDTO> getAllTodos() {
        return todoRepository.findAll().stream()
                .map(this::toResponseDTO)
                .collect(Collectors.toList());
    }

    // 생성
    public TodoResponseDTO createTodo(TodoRequestDTO request) {
        Todo todo = new Todo();
        todo.setTitle(request.getTitle());
        todo.setCompleted(request.isCompleted());

        Todo saved = todoRepository.save(todo);
        return toResponseDTO(saved);
    }

    // 수정
    public TodoResponseDTO updateTodo(Long id, TodoRequestDTO request) {
        Todo todo = todoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 ID 없음: " + id));
        todo.setTitle(request.getTitle());
        todo.setCompleted(request.isCompleted());

        return toResponseDTO(todoRepository.save(todo));
    }

    // 삭제
    public void deleteTodo(Long id) {
        todoRepository.deleteById(id);
    }

    private TodoResponseDTO toResponseDTO(Todo todo) {
        return new TodoResponseDTO(
                todo.getId(),
                todo.getTitle(),
                todo.isCompleted()
        );
    }
}
