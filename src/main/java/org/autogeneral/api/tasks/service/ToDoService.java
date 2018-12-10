package org.autogeneral.api.tasks.service;

import org.autogeneral.api.tasks.entity.Todo;
import org.autogeneral.api.tasks.repository.TodoRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class ToDoService {

    private TodoRepository todoRepository;

    public ToDoService(TodoRepository todoRepository){
        this.todoRepository = todoRepository;
    }
    public Todo saveTodo(Todo todo){
        return todoRepository.save(todo);
    }

    public Optional<Todo> findTodoById(Long id){
        return todoRepository.findById(id);
    }


}
