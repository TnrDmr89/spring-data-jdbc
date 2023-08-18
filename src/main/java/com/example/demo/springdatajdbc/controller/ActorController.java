package com.example.demo.springdatajdbc.controller;


import com.example.demo.springdatajdbc.model.Actor;
import com.example.demo.springdatajdbc.model.Film;
import com.example.demo.springdatajdbc.repository.ActorRepository;
import com.example.demo.springdatajdbc.service.ActorService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ActorController {

    @Autowired
    private ActorService actorService;

    @Autowired
    private ActorRepository actorRepository;
    /*
    {
    "firstName":"Ed",
    "lastName" : "Chase",
    "film":
       [
           {
             "title" : "Chamber Italian"
           },
           {
           "title" : "Analyze Hoosiers"
           },
           {
           "title" : "Blade Polish"
          }
       ]
     }
     */
    @RequestMapping(method = RequestMethod.POST,path = "/actor/saveActor")
    public ResponseEntity<?> saveActor(@RequestBody String data){
        JSONObject jSon = new JSONObject(data);
        if(jSon.length() > 0){
            this.actorService.saveActor(jSon);
            return new ResponseEntity<>("Basarılı", HttpStatus.ACCEPTED);
        }else{
            return new ResponseEntity<>("Başarısız", HttpStatus.BAD_REQUEST);
        }

    }

    @RequestMapping(path = "/actor/filmPlayed",method = RequestMethod.GET)
    public List<String> filmPlayed(@RequestParam("name") String name){
        return this.actorService.films(name);
    }


    @RequestMapping(path = "/actor/findById/{id}",method = RequestMethod.GET)
    public Actor findById(@PathVariable("id") Integer actorId){
        return this.actorRepository.findById(actorId).orElse(null);
    }
}
