package org.example.repository;

import org.example.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
