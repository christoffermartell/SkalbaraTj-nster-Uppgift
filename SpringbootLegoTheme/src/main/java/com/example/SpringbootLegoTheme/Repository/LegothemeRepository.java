package com.example.SpringbootLegoTheme.Repository;

import com.example.SpringbootLegoTheme.Entity.LegothemeEntity;

import com.example.SpringbootLegoTheme.Utils.GetThemes;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public class LegothemeRepository {
    private final List<LegothemeEntity> legoThemes = GetThemes.getThemeList();

    public Collection<LegothemeEntity>getAllThemes() {
        return legoThemes.stream().toList();
    }

    public Collection<LegothemeEntity> getSpecificTheme(String name){
        return legoThemes.stream().filter(n -> n.getName().equalsIgnoreCase(name)).toList();
    }
}
