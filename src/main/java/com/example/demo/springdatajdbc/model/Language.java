package com.example.demo.springdatajdbc.model;

import org.springframework.data.annotation.Id;
import java.time.LocalDateTime;
public class Language {

    @Id
    private Integer id;

    private String name;

    private LocalDateTime updatedOn;

    public Language(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Language(String name) {
        this.name = name;
    }

    public Language() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getUpdatedOn() {
        return updatedOn;
    }

    public void setUpdateOn(LocalDateTime updatedOn) {
        this.updatedOn = updatedOn;
    }
}
