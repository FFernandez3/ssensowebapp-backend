package com.app.samuraisenso.controllers;

import com.app.samuraisenso.domain.Ability;
import com.app.samuraisenso.repositories.AbilityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/ability")
public class AbilityController {
    private final AbilityRepository repositorio;

    @PostMapping("/create")
    public void createAbilities(){
        Ability ability1 = new Ability(1L,"Hiten Mitsurugi", "Tecnica de la escuela de Kenshin Himura", "Battou");
        Ability ability2 = new Ability(2L,"Kodachi Nito Ryuu", "Tecnica de la escuela de Aoshi Shinomori", "Kodachi");
        Ability ability3 = new Ability(3L,"Gatotsu", "Tecnica de la escuela de Saito Hajime", "Kendo");

        repositorio.save(ability1);
        repositorio.save(ability2);
        repositorio.save(ability3);
    }

    @GetMapping("/all")
    public List<Ability> getAbilities (){
        return repositorio.findAll();
    }
}
