package com.example.springnewproject.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class UserNotFoundException extends RuntimeException {
    private LocalDateTime timestamp;
    private int status;
    private String message;


    public UserNotFoundException(String message) {
        super(message);
        this.message = message;
        timestamp = LocalDateTime.now();
    }
}
