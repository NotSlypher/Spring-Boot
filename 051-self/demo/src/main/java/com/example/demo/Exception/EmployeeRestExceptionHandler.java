package com.example.demo.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class EmployeeRestExceptionHandler {
    @ExceptionHandler
    ResponseEntity<EmployeeErrorResponse> EmployeeNotFoundExceptionHandler(StudentNotFoundException exc){
        EmployeeErrorResponse errorResponse = new EmployeeErrorResponse();

        errorResponse.setMessage(exc.getMessage());
        errorResponse.setStatusCode(HttpStatus.NOT_FOUND.value());
        errorResponse.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }
}
