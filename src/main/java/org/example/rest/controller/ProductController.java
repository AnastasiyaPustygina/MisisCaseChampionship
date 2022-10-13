package org.example.rest.controller;

import lombok.RequiredArgsConstructor;
import org.example.domain.Product;
import org.example.rest.dto.ProductDto;
import org.example.service.ProductService;
import org.example.service.exception.ProductNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping("/product/ingredient/{ingredientId}")
    public ProductDto findProductByIngredientId(@PathVariable("ingredientId") int ingredientId){
        return ProductDto.toDto(productService.findByIngredientId(ingredientId));
    }

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<String> handlerProductNotFoundException(ProductNotFoundException e){
        return ResponseEntity.badRequest().body(e.getMessage());
    }

}
