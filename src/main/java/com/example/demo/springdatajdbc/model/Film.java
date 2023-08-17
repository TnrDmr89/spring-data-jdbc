package com.example.demo.springdatajdbc.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.jdbc.core.mapping.AggregateReference;
import java.time.LocalDateTime;

public class Film {

    @Id
    private Integer id;

    private String title;

    private Integer releaseYear;

    private LocalDateTime updated_on;

    private AggregateReference<Language,Integer> language;

    private FilmCategory filmCategory;


    public Film(String title, Integer releaseYear, AggregateReference<Language, Integer> language) {
        this.title = title;
        this.releaseYear = releaseYear;
        this.language = language;
    }

    public Film() {
    }

    public Integer getId() {

        return id;
    }

    public void setId(Integer id) {

        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(Integer releaseYear) {
        this.releaseYear = releaseYear;
    }

    public LocalDateTime getUpdated_on() {
        return updated_on;
    }

    public void setUpdated_on(LocalDateTime updated_on) {
        this.updated_on = updated_on;
    }

    public AggregateReference<Language, Integer> getLanguage() {
        return language;
    }

    public void setLanguage(AggregateReference<Language, Integer> language) {
        this.language = language;
    }

    public FilmCategory getFilmCategory() {
        return filmCategory;
    }

    public void setFilmCategory(Integer categoryId) {
        this.filmCategory = new FilmCategory(categoryId);

    }


}
