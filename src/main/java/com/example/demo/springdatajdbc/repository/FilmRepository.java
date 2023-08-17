package com.example.demo.springdatajdbc.repository;

import com.example.demo.springdatajdbc.model.Film;
import com.example.demo.springdatajdbc.model.FilmCategory;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;


public interface FilmRepository extends CrudRepository<Film,Integer> {
    Film findFilmByTitle(String title);
    @Query("select ctg.name from category as ctg where ctg.id = " +
            "(select flmctg.category from film_category as flmctg where flmctg.film = " +
            "(select flm.id from film as flm where title = :title))")
    String filmCategoryBytitle(String title);
}
