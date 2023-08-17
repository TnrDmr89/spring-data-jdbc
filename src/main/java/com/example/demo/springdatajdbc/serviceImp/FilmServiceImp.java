package com.example.demo.springdatajdbc.serviceImp;


import com.example.demo.springdatajdbc.model.Film;
import com.example.demo.springdatajdbc.model.Language;
import com.example.demo.springdatajdbc.repository.FilmRepository;
import com.example.demo.springdatajdbc.repository.LanguageRepository;
import com.example.demo.springdatajdbc.service.CategoryService;
import com.example.demo.springdatajdbc.service.FilmService;
import com.example.demo.springdatajdbc.service.LanguageService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jdbc.core.mapping.AggregateReference;
import org.springframework.stereotype.Service;
import java.util.NoSuchElementException;
import java.util.Optional;


@Service
public class FilmServiceImp implements FilmService {
     @Autowired
     private FilmRepository filmRepository;
    @Autowired
    private LanguageService languageService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private LanguageRepository languageRepository;

    @Override
    public void saveFilm(JSONObject jSon) {
       Film film = new Film();
       film.setTitle(jSon.getString("title"));
       film.setReleaseYear(jSon.getInt("releaseYear"));
       film.setLanguage(this.languageService.getLanguageId(jSon.getString("language")));
       film.setFilmCategory(this.categoryService.getCategoryId(jSon.getString("category")));
       this.filmRepository.save(film);
    }
    @Override
    public void updateFilmLanguage(String title, String language) {
        Film film = this.filmRepository.findFilmByTitle(title);
        Optional.ofNullable(film).orElseThrow(()->new NoSuchElementException("title " + title + " is not DB"));
        Optional<Language> lang = this.languageRepository.findLanguageByName(language);
        lang.orElseThrow(()-> new NoSuchElementException("language "+ language + " is not DB"));
        film.setLanguage(AggregateReference.to(lang.get().getId()));
        this.filmRepository.save(film);
    }
}
