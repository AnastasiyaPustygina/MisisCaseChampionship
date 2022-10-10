package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.domain.Product;
import org.example.repository.ProductRepository;
import org.example.service.exception.ProductNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService{

    private final ProductRepository productRepository;

    @Override
    public Product findByIngredientId(int id) {
        return productRepository.findByIngredientId(id).orElseThrow(() -> new
                ProductNotFoundException("Product was not found by category id " + id));
    }
}
