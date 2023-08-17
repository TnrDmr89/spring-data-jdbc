package com.example.demo.springdatajdbc.repository;

import com.example.demo.springdatajdbc.model.Category;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CategoryRepository extends CrudRepository<Category,Integer> {
    Optional<Category> findCategoryByName(String categoryName);
}
