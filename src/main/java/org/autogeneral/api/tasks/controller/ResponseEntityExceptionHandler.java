package org.autogeneral.api.tasks.controller;

import org.autogeneral.api.tasks.controller.response.NotFoundErrorResponse;
import org.autogeneral.api.tasks.exception.NotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class ExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public final ResponseEntity<NotFoundErrorResponse> handleUserNotFoundException(NotFoundException ex, WebRequest request) {
        return ResponseEntity.ok().build();

    }
}
