package com.project1.error;

import org.springframework.http.HttpStatus;

public class ClientException extends RuntimeException{
    HttpStatus status;
    public ClientException(String message) {
        super(message);
        this.status = HttpStatus.BAD_REQUEST;
    }
    public ClientException(String message,HttpStatus status) {
        super(message);
        this.status = status;
    }

    public HttpStatus getStatus() {
        return status;
    }
}