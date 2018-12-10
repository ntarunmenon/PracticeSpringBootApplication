package org.autogeneral.api.tasks.controller;

import org.autogeneral.api.tasks.entity.Todo;
import org.autogeneral.api.tasks.service.ToDoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Optional;

@RestController
@RequestMapping("/todo")
public class TodoController {

    private ToDoService toDoService;

    public TodoController(ToDoService toDoService){
        this.toDoService = toDoService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Todo> getToDoById(@PathVariable Long id){
        Optional<Todo> todoOptional = toDoService.findTodoById(id);
        if (todoOptional.isPresent()){
            return ResponseEntity.ok(todoOptional.get());
        } else {
            return ResponseEntity.noContent().build();
        }
    }

    @PostMapping
    public ResponseEntity<Todo> createToDo(@RequestBody Todo todo){
        return ResponseEntity.ok(toDoService.saveTodo(todo));
    }
}
