package com.example.demo.springdatajdbc.serviceImp;


import com.example.demo.springdatajdbc.model.Language;
import com.example.demo.springdatajdbc.repository.LanguageRepository;
import com.example.demo.springdatajdbc.service.LanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jdbc.core.mapping.AggregateReference;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LanguageServiceImp implements LanguageService {

    @Autowired
    private LanguageRepository languageRepository;
    @Override
    public AggregateReference<Language,Integer> getLanguageId(String language) {

        Optional<Language> lang =  this.languageRepository.findLanguageByName(language);

        if(lang.isPresent()){
           return AggregateReference.to(lang.get().getId());
        }
        else{
            Language langu = new Language(language);
            return AggregateReference.to(this.languageRepository.save(langu).getId());
        }
    }
}
