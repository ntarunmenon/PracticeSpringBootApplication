package org.autogeneral.api.tasks.controller;

import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.autogeneral.api.tasks.controller.request.ToDoItemAddRequest;
import org.autogeneral.api.tasks.controller.response.ErrorResponse;
import org.autogeneral.api.tasks.entity.Todo;
import org.autogeneral.api.tasks.service.ToDoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/todo")
public class TodoController {

    private ToDoService toDoService;

    public TodoController(ToDoService toDoService){
        this.toDoService = toDoService;
    }

    @GetMapping("/{id}")
    @ApiResponses( value =
            {@ApiResponse(code = 404,message = "Notfound Error",response = ErrorResponse.class)})
    public ResponseEntity<Todo> getToDoById(@PathVariable Long id){
       return ResponseEntity.ok(toDoService.findTodoById(id));
    }

    @PostMapping
    public ResponseEntity<Todo> createToDo(@RequestBody @Valid ToDoItemAddRequest toDoItemAddRequest){
        return ResponseEntity.ok(toDoService.saveTodo(new Todo((toDoItemAddRequest))));
    }
}
