package com.activedge.exception;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class StockAlreadyExistException extends RuntimeException{
    private String message;
    private String status;

    public StockAlreadyExistException(String message, HttpStatus status){
        this.message = message;
        this.status = String.valueOf(status);
    }
}
