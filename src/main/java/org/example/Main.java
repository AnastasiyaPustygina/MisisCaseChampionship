package org.example;

import org.example.repository.PersonRepository;
import org.example.repository.RecipeRepository;
import org.example.rest.controller.PersonController;
import org.example.rest.controller.RecipeController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;


@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(Main.class, args);

    }
}