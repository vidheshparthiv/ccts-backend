package com.ccts.springapp.exception;
public class ErrorResponse {
    private String message;
    
    public String getMessage() {
        return message;
    }

    public int getStatus() {
        return status;
    }

    private int status;

    public ErrorResponse(String message,int status){
        this.message=message;
        this.status=status;
    }
}