package org.autogeneral.api.tasks.service;


import org.autogeneral.api.tasks.entity.Todo;
import org.autogeneral.api.tasks.exception.NotFoundException;
import org.autogeneral.api.tasks.repository.TodoRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
@SuppressWarnings("unused")
public class ToDoService {

    private TodoRepository todoRepository;

    public ToDoService(TodoRepository todoRepository){
        this.todoRepository = todoRepository;
    }
    public Todo saveTodo(Todo todo){
        return todoRepository.save(todo);
    }

    public Todo findTodoById(Long id){
        Optional<Todo> todoOptional =  todoRepository.findById(id);
        if(todoOptional.isPresent()) {
            return todoOptional.get();
        }
        throw new NotFoundException(id);
    }


}
