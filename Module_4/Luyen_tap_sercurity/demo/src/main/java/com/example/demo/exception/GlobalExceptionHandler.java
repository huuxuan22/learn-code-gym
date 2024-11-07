package com.example.demo.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value = RuntimeException.class)
    ResponseEntity<String> handlingRunTimeException(RuntimeException runtimeException){
        return  ResponseEntity.badRequest().body(runtimeException.getMessage());
    }

    // đây là handler dùng cho validation
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    ResponseEntity<String> handlingExceptionValidation(MethodArgumentNotValidException methodArgumentNotValidException) {
        return  ResponseEntity.badRequest().body(methodArgumentNotValidException.getFieldError().getDefaultMessage());
    }
}
