package com.app.samuraisenso.controllers;

import com.app.samuraisenso.domain.Ability;
import com.app.samuraisenso.domain.AbilityType;
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

    @GetMapping("/create")
    public String createAbilities(){
        try{
            Ability ability1 = new Ability(1L,"Hiten Mitsurugi", "Tecnica de la escuela de Kenshin Himura", AbilityType.COMMON);
            Ability ability2 = new Ability(2L,"Kodachi Nito Ryuu", "Tecnica de la escuela de Aoshi Shinomori", AbilityType.ERUDITE);
            Ability ability3 = new Ability(3L,"Gatotsu", "Tecnica de la escuela de Saito Hajime", AbilityType.HIDDEN);

            repositorio.save(ability1);
            repositorio.save(ability2);
            repositorio.save(ability3);
            System.out.println("entro al create");
            return ("habilidades creadas");

        }
        catch (Exception e){
            return e.getMessage();
        }


    }

    @GetMapping("/all")
    public List<Ability> getAbilities (){
        return repositorio.findAll();
    }
}
