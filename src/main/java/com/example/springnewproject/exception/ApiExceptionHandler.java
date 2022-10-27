package com.example.springnewproject.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@RestControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    public final ResponseEntity<UserNotFoundException> userNotFound(Exception exc, WebRequest request)
    {
        UserNotFoundException exception = new UserNotFoundException(LocalDateTime.now(),404,exc.getMessage());
        return new ResponseEntity<UserNotFoundException>(exception, HttpStatus.NOT_FOUND);

    }
    @ExceptionHandler(NotFoundException.class)
    public final ResponseEntity<NotFoundException> notFoundExceptionResponseEntity(Exception exc, WebRequest request)
    {
        NotFoundException exception = new NotFoundException(LocalDateTime.now(),404,exc.getMessage());
        return new ResponseEntity<NotFoundException>(exception, HttpStatus.NOT_FOUND);

    }
}
