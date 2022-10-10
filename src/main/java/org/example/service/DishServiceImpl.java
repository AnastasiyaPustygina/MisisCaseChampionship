package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.domain.Dish;
import org.example.repository.DishRepository;
import org.example.service.exception.DishNotFoundException;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class DishServiceImpl implements DishService{

    private final DishRepository dishRepository;

    @Override
    public List<Dish> findByCategoryId(int id) {
        return dishRepository.findByCategoryId(id);
    }

    @Override
    public List<Dish> findTenByCategoryId(int id) {
        return dishRepository.findAllByCategoryId(id, PageRequest.of(0, 10)).toList();
    }

    @Override
    public Dish findById(int id) {
        return dishRepository.findById(id).orElseThrow( () ->
                new DishNotFoundException("Dish with id " + id + " was not found"));
    }

    @Override
    public List<Dish> findByCategoryIds(List<Integer> ids) {

        return dishRepository.findDishesByCategoryIds(ids, ids.size());
    }
}
