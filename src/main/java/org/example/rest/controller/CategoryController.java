package org.example.rest.controller;

import lombok.RequiredArgsConstructor;
import org.example.domain.Category;
import org.example.rest.dto.CategoryDto;
import org.example.service.CategoryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;


    @GetMapping("/category")
    public List<CategoryDto> findAllCategories(){
        return categoryService.findAll().stream().map(CategoryDto::toDto).toList();
    }

}
