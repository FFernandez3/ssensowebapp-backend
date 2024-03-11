package com.app.samuraisenso.controllers;

import com.app.samuraisenso.DTOs.ClanDTO;
import com.app.samuraisenso.domain.Clan;
import com.app.samuraisenso.services.ClanService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clanes")
@RequiredArgsConstructor
public class ClanController {
    @Autowired
    private ClanService clanService;

    @PostMapping
    public ResponseEntity<?> save(@RequestBody Clan c) {
        try{
            return ResponseEntity.status(HttpStatus.OK).body(clanService.save(c));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. No se pudo agregar el clan.\"}");
        }
    }

    @PutMapping
    public ResponseEntity<?> update(Long id, ClanDTO clanDTO) {
        try{
            return ResponseEntity.status(HttpStatus.OK).body(clanService.update(id, clanDTO));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. No se pudo editar la tupla.");
        }
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> deleteById (@PathVariable("id") Long id){
        try{
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(clanService.deleteById(id));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. No se pudo eliminar el clan con id  \"" + id + ".\"}");
        }
    }

    @GetMapping
    public ResponseEntity<?> getAll(){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(clanService.findAll());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. No se pudieron encontrar los clanes.\"}");
        }
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") Long id){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(clanService.findById(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. No se pudo encontrar el clan con id \"" + id + ".\"}");
        }
    }
}
