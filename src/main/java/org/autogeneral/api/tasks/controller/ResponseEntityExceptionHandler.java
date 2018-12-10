package org.autogeneral.api.tasks.controller;

import org.autogeneral.api.tasks.controller.response.NotFoundErrorDetail;
import org.autogeneral.api.tasks.controller.response.ErrorResponse;
import org.autogeneral.api.tasks.exception.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import java.text.MessageFormat;

@ControllerAdvice
@RestController
public class ResponseEntityExceptionHandler extends org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public final ResponseEntity<ErrorResponse> handleNotFoundException(NotFoundException ex, WebRequest request) {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setName("NotFoundError");
        NotFoundErrorDetail notFoundErrorDetail = new NotFoundErrorDetail();
        notFoundErrorDetail.setMessage(MessageFormat.format("Item with {0} not found",ex.getId()));
        errorResponse.addErrorDetail(notFoundErrorDetail);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
    }
}
