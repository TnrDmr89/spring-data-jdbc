package com.example.demo.springdatajdbc.repository;

import com.example.demo.springdatajdbc.model.Actor;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ActorRepository extends CrudRepository<Actor,Integer> {

    @Query("select flm.title from film as flm where flm.id IN " +
            "(select flmact.film from film_actor as flmact where flmact.actor = " +
            "(select act.id from actor as act where act.first_name = :name))")
    List<String> films(String name);
}
