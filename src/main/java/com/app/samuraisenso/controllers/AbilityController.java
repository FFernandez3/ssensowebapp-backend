package com.app.samuraisenso.controllers;

import com.app.samuraisenso.DTOs.AbilityRequestDTO;
<<<<<<< HEAD
import com.app.samuraisenso.DTOs.AbilityResponseDTO;
=======
>>>>>>> 809dd023f51afb212fb8ac7e780fae0ee9b8fc5c
import com.app.samuraisenso.domain.Ability;
import com.app.samuraisenso.domain.AbilityType;
import com.app.samuraisenso.repositories.AbilityRepository;
import com.app.samuraisenso.services.AbilityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/ability")
public class AbilityController {
    private final AbilityService service;

    @PostMapping("/create")
    public ResponseEntity<AbilityResponseDTO> createAbilities(AbilityRequestDTO request){
           /* Ability ability1 = new Ability(1L,"Hiten Mitsurugi", "Tecnica de la escuela de Kenshin Himura", AbilityType.COMMON);
            Ability ability2 = new Ability(2L,"Kodachi Nito Ryuu", "Tecnica de la escuela de Aoshi Shinomori", AbilityType.ERUDITE);
            Ability ability3 = new Ability(3L,"Gatotsu", "Tecnica de la escuela de Saito Hajime", AbilityType.HIDDEN);

            repositorio.save(ability1);
            repositorio.save(ability2);
            repositorio.save(ability3);*/
            //System.out.println("entro al create");
            return ResponseEntity.ok(service.createAbilities(request));

    }

    @GetMapping("/getAll")
    public List<Ability> getAbilities (){
        return repositorio.findAll();
    }

    @GetMapping("/getBy/{id}")
    public ResponseEntity<Ability> getAbilityById(@PathVariable Long id){
        Optional<Ability> opt = repositorio.findById(id);

        if (opt.isEmpty()) {
            return ResponseEntity.badRequest().build();
        } else {
            return ResponseEntity.ok(opt.get());
        }
    }

    @PostMapping
    public ResponseEntity<Ability> saveAbility (@RequestBody AbilityRequestDTO abilityDto){
        //if (ability.getId() != null) {
        //    return ResponseEntity.badRequest().build();
        //}
        Ability abilityEntity = new Ability(abilityDto);
        repositorio.save(abilityEntity);
        return ResponseEntity.ok(abilityEntity);
    }
}
