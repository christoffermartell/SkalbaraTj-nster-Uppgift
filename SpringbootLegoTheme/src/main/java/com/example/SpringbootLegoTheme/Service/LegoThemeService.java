package com.example.SpringbootLegoTheme.Service;

import com.example.SpringbootLegoTheme.Entity.LegothemeEntity;
import com.example.SpringbootLegoTheme.Repository.LegothemeRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class LegoThemeService {

    LegothemeRepository repository;

    public LegoThemeService(LegothemeRepository repository){
        this.repository = repository;
    }

    public Collection<LegothemeEntity> getAllThemes(){
        return repository.getAllThemes();
    }

    public Collection<LegothemeEntity> getSpecificTheme(String name){
        if (!name.isEmpty()){
            return repository.getSpecificTheme(name);
        }
        return null;
    }

}
