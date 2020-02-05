package com.employee.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class ValidationExceptionHandler {

    @ExceptionHandler(ValidationException.class)
    public ErrorResponse handleBadRequest(ValidationException exception, WebRequest webRequest) {
        String requestPath = ((ServletWebRequest) webRequest).getRequest().getRequestURI();
        ErrorResponse errorResponse = new ErrorResponse(exception.getMessage(),
                HttpStatus.BAD_REQUEST.value(), "employeeService", requestPath);
        return errorResponse;

    }
}
