package com.example.demo.springdatajdbc.serviceImp;


import com.example.demo.springdatajdbc.model.Category;
import com.example.demo.springdatajdbc.repository.CategoryRepository;
import com.example.demo.springdatajdbc.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoryServiceImp implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;
    @Override
    public Integer getCategoryId(String categoryName) {
        Optional<Category> category = this.categoryRepository.findCategoryByName(categoryName);
        if( category.isPresent()){
            return category.get().getId();
        }else{
            Category cat = new Category(categoryName);
            return this.categoryRepository.save(cat).getId();
        }
    }
}
