package org.example.service.exception;

public class DishNotFoundException extends RuntimeException{
    public DishNotFoundException(String message) {
        super(message);
    }
}
