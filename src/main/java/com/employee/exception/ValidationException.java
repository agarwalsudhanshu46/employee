package com.employee.exception;

public class ValidationException extends RuntimeException {

    private String message;

    public ValidationException(String message ){
        super(message);
    }
}
