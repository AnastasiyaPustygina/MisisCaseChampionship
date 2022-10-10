package org.example.service.exception;

public class RecipeNotFoundException extends RuntimeException{
    public RecipeNotFoundException(String message) {
        super(message);
    }
}
