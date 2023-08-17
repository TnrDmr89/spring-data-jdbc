package com.example.demo.springdatajdbc.service;

import com.example.demo.springdatajdbc.model.Language;
import org.springframework.data.jdbc.core.mapping.AggregateReference;

public interface LanguageService {

    AggregateReference<Language,Integer> getLanguageId(String language);


}
