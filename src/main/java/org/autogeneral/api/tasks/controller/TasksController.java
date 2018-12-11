package org.autogeneral.api.tasks.controller;

import org.autogeneral.api.tasks.controller.response.BalanceTestResult;
import org.autogeneral.api.tasks.service.TasksService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Pattern;

@RestController
@RequestMapping("/tasks")
@Validated
public class TasksController {

    private TasksService tasksService;

    public TasksController(TasksService tasksService) {
        this.tasksService = tasksService;
    }

    @GetMapping("validateBrackets")
    public BalanceTestResult balanceTest(@RequestParam("input")
                                         @Valid
                                             @Pattern(regexp = "^[\\(\\{\\[\\)\\}\\]]+$",
                                                     message = "Should contain only following characters {,[,(,},],)") String input) {
        return new BalanceTestResult(input, tasksService.isBalanced(input));
    }
}
