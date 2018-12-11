package org.practice.api.tasks.controller;

import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.practice.api.tasks.controller.error.ToDoItemNotFoundError;
import org.practice.api.tasks.controller.error.ToDoValidationError;
import org.practice.api.tasks.controller.response.BalanceTestResult;
import org.practice.api.tasks.service.TasksService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.Pattern;

@RestController
@RequestMapping("/tasks")
@Validated
@SuppressWarnings("unused")
public class TasksController {

    private TasksService tasksService;

    public TasksController(TasksService tasksService) {
        this.tasksService = tasksService;
    }

    @GetMapping("validateBrackets")
    @ApiResponses(value =
            {@ApiResponse(code = 404, message = "Notfound Error", response = ToDoItemNotFoundError.class),
                    @ApiResponse(code = 400, message = "Validation Error", response = ToDoValidationError.class)})
    public BalanceTestResult balanceTest(@RequestParam("input")
                                         @Valid
                                             @Pattern(regexp = "^[\\(\\{\\[\\)\\}\\]]+$",
                                                     message = "Should contain only following characters {,[,(,},],)") String input) {
        return new BalanceTestResult(input, tasksService.isBalanced(input));
    }
}
