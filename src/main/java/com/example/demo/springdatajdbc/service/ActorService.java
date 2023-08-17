package com.example.demo.springdatajdbc.service;

import org.json.JSONObject;

import java.util.List;

public interface ActorService {

     void saveActor(JSONObject jSon);

     List<String> films(String name);
}
