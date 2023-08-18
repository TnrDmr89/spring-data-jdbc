package com.example.demo.springdatajdbc.controller;

import com.example.demo.springdatajdbc.model.Film;
import com.example.demo.springdatajdbc.repository.FilmRepository;
import com.example.demo.springdatajdbc.service.FilmService;
import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/film")
public class FilmController {

    private FilmService filmService;

    private FilmRepository filmRepository;

    public FilmController(FilmService film,FilmRepository filmRep){

        this.filmService=film;
        this.filmRepository = filmRep;
    }

    /*

       {
       "title" : "Bang Kwai",
       "releaseYear" : 2003,
       "language" : "French",
       "category": "Comedy"
       }
     */
    @PostMapping(value = "/saveFilm")
    public ResponseEntity<?> saveFilm(@RequestBody String data ){
        JSONObject jSon = new JSONObject(data);
        if(jSon.length() > 0){
            this.filmService.saveFilm(jSon);
            return new ResponseEntity("Basarılı", HttpStatus.ACCEPTED);
        }

        return new ResponseEntity("Başarısız", HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/takeFilmCategory")
    public String takeFilmCategory(@RequestParam("title") String title){
       String s = this.filmRepository.filmCategoryBytitle(title);
        return s;
    }

    @PutMapping("updateFilmLanguage")
    public void updateFilmLanguage(@RequestParam("title") String title, @RequestParam("language") String language){
        this.filmService.updateFilmLanguage(title,language);
    }

    @GetMapping("/findFilm/{id}")
    public Film finFilmById(@PathVariable Integer id){
        return this.filmRepository.findById(id).orElse(null);
    }

}
