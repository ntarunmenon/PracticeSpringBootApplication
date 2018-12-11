package org.practice.api.tasks.controller;

import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.practice.api.tasks.controller.error.ToDoItemNotFoundError;
import org.practice.api.tasks.controller.error.ToDoValidationError;
import org.practice.api.tasks.controller.request.ToDoItemAddRequest;
import org.practice.api.tasks.entity.Todo;
import org.practice.api.tasks.service.ToDoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;

@RestController
@RequestMapping("/todo")
@SuppressWarnings("unused")
public class TodoController {

    private ToDoService toDoService;

    public TodoController(ToDoService toDoService) {
        this.toDoService = toDoService;
    }

    @GetMapping("/{id}")
    @ApiResponses(value =
            {@ApiResponse(code = 404, message = "Notfound Error", response = ToDoItemNotFoundError.class),
                    @ApiResponse(code = 400, message = "Validation Error", response = ToDoValidationError.class)})
    public ResponseEntity<Todo> getToDoById(@PathVariable Long id) {
        return ResponseEntity.ok(toDoService.findTodoById(id));
    }

    @PostMapping
    @ApiResponses(value =
            {@ApiResponse(code = 404, message = "Notfound Error", response = ToDoItemNotFoundError.class),
                    @ApiResponse(code = 400, message = "Validation Error", response = ToDoValidationError.class)})
    public ResponseEntity<Todo> createToDo(@Valid @RequestBody ToDoItemAddRequest toDoItemAddRequest) {
        return ResponseEntity.ok(toDoService.saveTodo(new Todo(toDoItemAddRequest)));
    }

    @PatchMapping("/{id}")
    @ApiResponses(value =
            {@ApiResponse(code = 404, message = "Notfound Error", response = ToDoItemNotFoundError.class),
                    @ApiResponse(code = 400, message = "Validation Error", response = ToDoValidationError.class)})
    public ResponseEntity<Todo> updateTodo(@PathVariable Long id, @Valid @RequestBody ToDoItemAddRequest toDoItemAddRequest) {
        Todo todo = toDoService.findTodoById(id);
        todo.setText(toDoItemAddRequest.getText());
        todo.setCompleted(toDoItemAddRequest.isCompleted());
        todo.setCreatedAt(LocalDateTime.now());
        return ResponseEntity.ok(toDoService.saveTodo(todo));

    }
}
