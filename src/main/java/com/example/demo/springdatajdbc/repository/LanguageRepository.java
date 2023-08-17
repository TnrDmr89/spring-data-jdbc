package com.example.demo.springdatajdbc.repository;

import com.example.demo.springdatajdbc.model.Language;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface LanguageRepository extends CrudRepository<Language,Integer> {

    Optional<Language> findLanguageByName(String name);

}
