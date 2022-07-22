package com.geekbrains.spring.web.exceptions;

public class ExistEntityException extends RuntimeException{
    public ExistEntityException(String message) {
        super(message);
    }
}
