package org.example.service;

import org.example.domain.Dish;

import java.util.List;
import java.util.Optional;

public interface DishService {
    List<Dish> findByCategoryId(int id);
    List<Dish> findTenByCategoryId(int id);
    Dish findById(int id);
    List<Dish> findByCategoryIds(Integer[] ids);
}
