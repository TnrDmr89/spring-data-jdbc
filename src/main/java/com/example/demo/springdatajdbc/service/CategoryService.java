package com.example.demo.springdatajdbc.service;

import org.springframework.data.jdbc.core.mapping.AggregateReference;

public interface CategoryService {

   Integer getCategoryId(String categoryName);
}
