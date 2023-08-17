package com.example.demo.springdatajdbc.model;

import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

public class Category {

    @Id
    private Integer id;

    private String name;

    private LocalDateTime lastUpdate;

    public Category(Integer id,String name) {
        this.id = id;
        this.name = name;
    }

    public Category(String name) {
        this.name = name;
    }

    public Category() {
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

    public LocalDateTime getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(LocalDateTime lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
}
