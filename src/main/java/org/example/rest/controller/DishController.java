package org.example.rest.controller;

import lombok.RequiredArgsConstructor;
import org.example.domain.Dish;
import org.example.rest.dto.DishDto;
import org.example.service.DishService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping("/dish/categories/")
    public List<DishDto> findDishesByCategoryIds(@RequestBody List<Integer> ingredientIds){
        List<Dish> dishes = dishService.findByCategoryIds(ingredientIds);
        return dishes.stream().map(DishDto::toDto).toList();
    }

}
