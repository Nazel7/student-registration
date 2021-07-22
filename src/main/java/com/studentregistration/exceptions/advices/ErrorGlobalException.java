package com.studentregistration.exceptions.advices;

import com.studentregistration.exceptions.StudentNotFoundException;
import com.studentregistration.usercases.dtos.request.ExceptionMessage;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Date;

@RestControllerAdvice
public class ErrorGlobalException {

    @ExceptionHandler
    public ResponseEntity<ExceptionMessage> createStudentNotFound(StudentNotFoundException exception){

        ExceptionMessage errorResponse= new ExceptionMessage();

        errorResponse.setErrorStatus(HttpStatus.NOT_FOUND+ "");
        errorResponse.setMessage(exception.getMessage());
        errorResponse.setTimeStamp(System.currentTimeMillis() +"");

        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }
}
