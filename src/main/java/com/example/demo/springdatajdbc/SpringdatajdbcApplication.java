package com.example.demo.springdatajdbc;

import com.example.demo.springdatajdbc.model.*;
import com.example.demo.springdatajdbc.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jdbc.core.mapping.AggregateReference;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class SpringdatajdbcApplication {

	public static void main(String[] args) {

		SpringApplication.run(SpringdatajdbcApplication.class, args);
	}

	@Bean
	CommandLineRunner run(
			  LanguageRepository languageRepository
			, CategoryRepository categoryRepository
			, ActorRepository actorRepository
	        , FilmRepository filmRepository){
		return args -> {
		//	AggregateReference<Author,Integer> author =AggregateReference.to(authorRepository.save(new Author(1,"Taner","Demir","tdemir@gmail.com","tdemir")).getId());
		//	Post post = new Post("Moltress!","Pokemoon1",author);
		//	post.addComment(new Comment("dandanss","This is my second comment"));
		//	posts.save(post);

		/*
            Category cat = new Category(null,"Action");
			AggregateReference<Language,Integer> language = AggregateReference.to(languageRepository.save(new Language(1,"Italian")).getId());
			AggregateReference<Category,Integer> category = AggregateReference.to(categoryRepository.save(cat).getId());
			AggregateReference<Actor,Integer> actor1 = AggregateReference.to(actorRepository.save(new Actor(null,"aaa","Guiness")).getId());
			AggregateReference<Actor,Integer> actor2 = AggregateReference.to(actorRepository.save(new Actor(null,"bbb","Wahlberg")).getId());
			Film newFilm = new Film("Ace Goldfingeddr",2014,language);
			newFilm.setFilmCategory(category.getId());
			//AggregateReference<Film,Integer> film = AggregateReference.to(filmRepository.save(newFilm).getId());
			filmRepository.save(newFilm);


		 */



		/*

          Actor actor1 = new Actor(null,"Penelope","Guiness");
		  Actor actor2 = new Actor(null,"Nick","Wahlberg");

		  Language language1 = new Language(null,"English");
		  Language language2 = new Language(null,"İtalian");


		  AggregateReference<Language,Integer> lan1= AggregateReference.to(languageRepository.save(language1).getId());
		  AggregateReference<Language,Integer> lan2= AggregateReference.to(languageRepository.save(language2).getId());

		  Film film1 = new Film("Ace Goldfingeddr",2014,lan1);
		  Film film2 = new Film("Adaptation Holes",2010,lan2);
		  Film film3 = new Film("Agent Truman",2015,lan1);


		  AggregateReference<Film,Integer> fil1 = AggregateReference.to(filmRepository.save(film1).getId());
		  AggregateReference<Film,Integer> fil2 = AggregateReference.to(filmRepository.save(film2).getId());
		  AggregateReference<Film,Integer> fil3 = AggregateReference.to(filmRepository.save(film3).getId());

		  actor1.addFilm(fil1.getId());
		  actor1.addFilm(fil2.getId());

		  actor2.addFilm(fil1.getId());
		  actor2.addFilm(fil3.getId());

		  actorRepository.save(actor1);
		  actorRepository.save(actor2);

		  actor1.addFilm(fil3.getId());
		  actorRepository.save(actor1);



		 */
		};

	}

}
