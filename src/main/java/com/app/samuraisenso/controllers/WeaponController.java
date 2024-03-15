package com.app.samuraisenso.controllers;

import com.app.samuraisenso.DTOs.request.WeaponRequestDTO;
import com.app.samuraisenso.DTOs.response.WeaponResponseDTO;
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
    public WeaponResponseDTO save(@RequestBody WeaponRequestDTO requestDTO) throws Exception{
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
            return ResponseEntity.ok(weaponFinded);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {
        Optional<WeaponResponseDTO> entityDeleted = weaponService.deleteById(id);
        return ResponseEntity.ok(entityDeleted);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?>edit(@PathVariable Long id, @RequestBody WeaponRequestDTO requestDTO) throws Exception{
        WeaponResponseDTO entityEdited=weaponService.edit(id, requestDTO);
        return ResponseEntity.ok(entityEdited);



    }


}
