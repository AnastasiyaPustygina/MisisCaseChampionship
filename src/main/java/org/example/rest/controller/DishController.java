package org.example.rest.controller;

import lombok.RequiredArgsConstructor;
import org.example.domain.Dish;
import org.example.rest.dto.DishDto;
import org.example.service.DishService;
import org.example.service.exception.DishNotFoundException;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class DishController {

    private final DishService dishService;

    @GetMapping("/dish/category/{categoryId}")
    public List<DishDto> findDishesByCategoryId(@PathVariable("categoryId") int categoryId){
        return dishService.findByCategoryId(categoryId).stream().map(DishDto::toDto).toList();
    }

    @GetMapping("/dish/ten/category/{categoryId}")
    public List<DishDto> findTenDishesByCategoryId(@PathVariable("categoryId") int categoryId){
        return dishService.findTenByCategoryId(categoryId).stream().map(DishDto::toDto).toList();
    }

    @GetMapping("/dish/{id}")
    public DishDto findDishById(@PathVariable("id") int id){
        return DishDto.toDto(dishService.findById(id));
    }

    @GetMapping("/dish/categories")
    public List<DishDto> findDishesByCategoryIds(@RequestParam(value = "ids") List<Integer> ids){
        List<Dish> dishes = dishService.findByCategoryIds(ids);
        return dishes.stream().map(DishDto::toDto).toList();
    }

    @ExceptionHandler(DishNotFoundException.class)
    public ResponseEntity<String> handlerDishNotFoundException(DishNotFoundException e){
        return ResponseEntity.badRequest().body(e.getMessage());
    }

}
