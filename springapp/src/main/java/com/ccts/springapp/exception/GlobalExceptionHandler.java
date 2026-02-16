package com.ccts.springapp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    // // exception for product
    // @ExceptionHandler(ProjectNotFoundException.class)
    // public ResponseEntity<String> name(ProjectNotFoundException ex){
    //     return new ResponseEntity<>(ex.getMessage(),HttpStatus.NOT_FOUND);
    // }

    // // exception for user by role
    // @ExceptionHandler(RoleNotFound.class)
    // public ResponseEntity<String> named (RoleNotFound ex){
    //     return new ResponseEntity<>(ex.getMessage(),HttpStatus.NOT_FOUND);
    // }

    //exception for user by email
    @ExceptionHandler(EmailNotFound.class)
    public ResponseEntity<String> namedEmail (EmailNotFound ex){
        return new ResponseEntity<>(ex.getMessage(),HttpStatus.NOT_FOUND);
    }
}
