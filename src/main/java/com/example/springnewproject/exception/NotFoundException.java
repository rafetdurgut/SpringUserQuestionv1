package com.example.springnewproject.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class NotFoundException extends RuntimeException {
    private LocalDateTime timestamp;
    private int status;
    private String message;


    public NotFoundException(String message) {
        super(message,null,false,false);
        this.message = message;
        timestamp = LocalDateTime.now();
    }
}
