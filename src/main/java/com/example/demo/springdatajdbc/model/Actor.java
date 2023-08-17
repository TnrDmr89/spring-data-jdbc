package com.example.demo.springdatajdbc.model;

import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

public class Actor {

    @Id
    private Integer id;

    private String firstName;

    private String lastName;

    private LocalDateTime lastUpdate;

    private Set<FilmActor> filmActorSet = new HashSet<>();

    public Actor(Integer id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Actor() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDateTime getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(LocalDateTime lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public Set<FilmActor> getFilmActorSet() {
        return filmActorSet;
    }

    public void setFilmActorSet(Set<FilmActor> filmActorSet) {
        this.filmActorSet = filmActorSet;
    }

    public void addFilm(Integer film){

        filmActorSet.add(new FilmActor(film));
    }
}
