package com.app.samuraisenso.controllers;

import com.app.samuraisenso.domain.Ability;
import com.app.samuraisenso.repositories.AbilityRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AbilityController {
    AbilityRepository repositorio;

    public AbilityController(AbilityRepository repo){
        this.repositorio = repo;
    }

    @GetMapping("/api/createAbilities")
    public void createAbilities(){
        Ability habilidad1 = new Ability(1L,"Hiten Mitsurugi", "Tecnica de la escuela de Kenshin Himura", "Battou");
        Ability habilidad2 = new Ability(2L,"Kodachi Nito Ryuu", "Tecnica de la escuela de Aoshi Shinomori", "Kodachi");
        Ability habilidad3 = new Ability(3L,"Gatotsu", "Tecnica de la escuela de Saito Hajime", "Kendo");

        repositorio.save(habilidad1);
        repositorio.save(habilidad2);
        repositorio.save(habilidad3);
    }

    @GetMapping("/api/abilities")
    public List<Ability> getHabilidades (){
        return repositorio.findAll();
    }
}
