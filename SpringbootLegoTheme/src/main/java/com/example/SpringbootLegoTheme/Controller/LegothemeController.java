package com.example.SpringbootLegoTheme.Controller;
import com.example.SpringbootLegoTheme.Entity.LegothemeEntity;
import com.example.SpringbootLegoTheme.Service.LegoThemeService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@CrossOrigin
@RestController
public class LegothemeController {


    LegoThemeService service;

    public LegothemeController(LegoThemeService service) {
        this.service = service;
    }


    @GetMapping("/test")
    public String test(){
        return "test";
    }

    @GetMapping("/all")
    public Collection<LegothemeEntity>getAllThemes(){
        System.out.println(service.getAllThemes());
        return service.getAllThemes();
    }

    @GetMapping("/{name}")
    public Collection<LegothemeEntity>getSpecificTheme(@PathVariable("name") String name){
        System.out.println(service.getSpecificTheme(name));

        return service.getSpecificTheme(name);
    }

}
