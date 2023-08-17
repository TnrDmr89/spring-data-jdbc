package com.example.demo.springdatajdbc.service;

import org.json.JSONObject;

public interface FilmService {
    void saveFilm(JSONObject jSon);

    void updateFilmLanguage(String title,String language);
}
