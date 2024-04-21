package com.example.demo.exceptions;

import com.example.demo.entity.EmployeeErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class EmployeeRestControllerAdvice {

    //Handle exception of specific type
    @ExceptionHandler
    public ResponseEntity<EmployeeErrorResponse> employeeExceptionHandler(Exception exception){
        EmployeeErrorResponse errorResponse=new EmployeeErrorResponse();
        errorResponse.setStatus(HttpStatus.NOT_FOUND.value());
        errorResponse.setMessage(exception.getMessage());
        errorResponse.setTimeStamp(System.currentTimeMillis());
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

}
