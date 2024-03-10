package com.app.samuraisenso.controllers;

import com.app.samuraisenso.DTOs.WeaponRequestDTO;
import com.app.samuraisenso.DTOs.WeaponResponseDTO;
import com.app.samuraisenso.services.WeaponService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/weapon")
@RequiredArgsConstructor
public class WeaponController {
    private final WeaponService weaponService;

    @PostMapping("")
    public WeaponResponseDTO save(WeaponRequestDTO requestDTO) throws Exception{
        return this.weaponService.save(requestDTO);
    }

    @GetMapping("")
    public ResponseEntity<List<WeaponResponseDTO>>findAll( ){
        List<WeaponResponseDTO> list=this.weaponService.findAll();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        Optional<WeaponResponseDTO> weaponFinded=this.weaponService.findById(id);
        if(weaponFinded.isPresent()){
            return ResponseEntity.ok(weaponFinded);
        }
        else {
            return ResponseEntity.status(404).body("Not found weapon with ID: "+ id);

        }


    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {
        Optional<WeaponResponseDTO> entityDeleted = weaponService.deleteById(id);

        if (entityDeleted.isPresent()) {
            return ResponseEntity.ok(entityDeleted);
        } else {
            return ResponseEntity.status(404).body("Not found weapon with ID: "+id);
        }
    }

    @PutMapping("")
    public ResponseEntity<?>edit(@PathVariable Long id, WeaponRequestDTO requestDTO) throws Exception{
        Optional<WeaponResponseDTO> entityEdited=weaponService.edit(id, requestDTO);
        if ((entityEdited.isPresent())){
            return ResponseEntity.ok(entityEdited);
        }
        else {
            return ResponseEntity.status(404).body("Not found weapon with ID: "+id);
        }

    }


}
