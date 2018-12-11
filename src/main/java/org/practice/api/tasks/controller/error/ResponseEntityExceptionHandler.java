package org.practice.api.tasks.controller.error;

import org.autogeneral.api.tasks.controller.error.*;
import org.practice.api.tasks.exception.NotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.text.MessageFormat;

@ControllerAdvice
@RestController
public class ResponseEntityExceptionHandler extends org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public final ResponseEntity<ToDoError> handleNotFoundException(NotFoundException ex, WebRequest request) {
        ToDoItemNotFoundError toDoError = new ToDoItemNotFoundError();
        ToDoNotFoundErrorDetail notFoundErrorDetail = new ToDoNotFoundErrorDetail();
        notFoundErrorDetail.setMessage(MessageFormat.format("Item with {0} not found",ex.getId()));
        toDoError.addErrorDetail(notFoundErrorDetail);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(toDoError);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public final ResponseEntity<ToDoError> handleConstraintViolationException(ConstraintViolationException ex, WebRequest request) {
        ToDoValidationError toDoError = new ToDoValidationError();
        ex.getConstraintViolations().forEach(constraintViolation -> toDoError.addErrorDetail(createErrorDetail(constraintViolation)));
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(toDoError);
    }

    private ToDoValidationErrorDetail createErrorDetail(ConstraintViolation<?> constraintViolation) {
        ToDoValidationErrorDetail toDoValidationErrorDetail = new ToDoValidationErrorDetail();
        toDoValidationErrorDetail.setLocation("params");
        toDoValidationErrorDetail.setMsg(constraintViolation.getMessage());
        toDoValidationErrorDetail.setValue(constraintViolation.getInvalidValue().toString());
        return toDoValidationErrorDetail;
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        ToDoValidationError toDoError = new ToDoValidationError();

        ToDoValidationErrorDetail toDoValidationErrorDetail = new ToDoValidationErrorDetail();
        toDoValidationErrorDetail.setLocation("params");
        toDoValidationErrorDetail.setMsg(ex.getBindingResult().getFieldError().getDefaultMessage());
        toDoValidationErrorDetail.setParam(ex.getBindingResult().getFieldError().getField());
        toDoValidationErrorDetail.setValue(ex.getBindingResult().getFieldError().getRejectedValue().toString());
        toDoError.addErrorDetail(toDoValidationErrorDetail);

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(toDoError);
    }
}
