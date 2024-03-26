package com.app.samuraisenso.exceptions;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalHandlerException {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<Map<String,String>> addAnswerExceptionHandler(EntityNotFoundException ex){
        Map<String,String> resp = new HashMap<>();
        resp.put("ENTITY_ERROR", ex.getMessage());
        return new ResponseEntity<>(resp, HttpStatus.NOT_FOUND);
    }
}
