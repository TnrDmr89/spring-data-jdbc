package com.example.demo.springdatajdbc.serviceImp;


import com.example.demo.springdatajdbc.model.Actor;
import com.example.demo.springdatajdbc.model.Film;
import com.example.demo.springdatajdbc.repository.ActorRepository;
import com.example.demo.springdatajdbc.repository.FilmRepository;
import com.example.demo.springdatajdbc.service.ActorService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ActorServiceImp implements ActorService {

    @Autowired
    private ActorRepository actorRepository;

    @Autowired
    private FilmRepository filmRepository;

    @Override
    public void saveActor(JSONObject jSon) {
        Actor actor = new Actor();
        actor.setFirstName(jSon.getString("firstName"));
        actor.setLastName(jSon.getString("lastName"));
        Film fl = this.filmRepository.findFilmByTitle("Agent Truman");
        for(int i = 0; i < jSon.getJSONArray("film").length(); i++){
            actor.addFilm(this.filmRepository.findFilmByTitle(
                    new JSONObject
                            (jSon.getJSONArray("film").get(i).toString())
                            .getString("title")

            ).getId());
        }
      this.actorRepository.save(actor);
    }
    @Override
    public List<String> films(String name) {
        return this.actorRepository.films(name);
    }
}
