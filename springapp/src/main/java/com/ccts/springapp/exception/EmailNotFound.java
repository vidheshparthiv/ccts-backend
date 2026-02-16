package com.ccts.springapp.exception;

public class EmailNotFound extends RuntimeException{
    public EmailNotFound(String status){
        super("User not found with email: "+ status);
    }
}