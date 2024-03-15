package com.app.samuraisenso.services;

import com.app.samuraisenso.DTOs.request.WeaponRequestDTO;
import com.app.samuraisenso.DTOs.response.WeaponResponseDTO;
import com.app.samuraisenso.domain.Weapon;
import com.app.samuraisenso.repositories.WeaponRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class WeaponService {
    private final WeaponRepository weaponRepository;

    public Optional<WeaponResponseDTO> findById(Long id) throws EntityNotFoundException{
        Optional<Weapon>weapon=this.weaponRepository.findById(id);

        if(weapon.isPresent()){
            return weapon
                .map(w -> new WeaponResponseDTO
                    (w.getId(), w.getName(),
                            w.is_personalized(), w.getPrice(),
                            w.getDescription() ));

        }
        else {
            throw new EntityNotFoundException("Not found weapon with ID: "+id);
        }


    }
    @Transactional
    public WeaponResponseDTO save(WeaponRequestDTO requestDTO) throws Exception{
        try {
            System.out.println("weaponDTO"+requestDTO.getName());
            Weapon newWeapon=new Weapon(requestDTO);
            Weapon savedWeapon = this.weaponRepository.save(newWeapon);
            System.out.println("weapon"+savedWeapon.getName());

            return new WeaponResponseDTO(
                    savedWeapon.getId(),
                    savedWeapon.getName(),
                    savedWeapon.is_personalized(),
                    savedWeapon.getPrice(),
                    savedWeapon.getDescription());
        }
        catch (Exception e) {
            throw new Exception("Error al crear la entidad");
        }
    }

    public List<WeaponResponseDTO> findAll() {
        return this.weaponRepository.findAll().stream()
                .map(weapon -> new WeaponResponseDTO(weapon.getId(), weapon.getName(),
                        weapon.is_personalized(), weapon.getPrice(),
                        weapon.getDescription()))
                .toList();

    }
    @Transactional
    public Optional<WeaponResponseDTO> deleteById(Long id) throws EntityNotFoundException {
        Optional<Weapon> entityToDelete = weaponRepository.findById(id);
        if(entityToDelete.isPresent()){
            entityToDelete.ifPresent(entity -> weaponRepository.deleteById(id));

            return entityToDelete.map(weapon -> new WeaponResponseDTO
                    (weapon.getId(), weapon.getName(),
                            weapon.is_personalized(), weapon.getPrice(),
                            weapon.getDescription()));

        }
        else {
            throw new EntityNotFoundException("Not found weapon with ID: "+id);
        }


    }

    @Transactional
    public WeaponResponseDTO edit(Long id, WeaponRequestDTO weaponRequestDTO) throws Exception {
        Optional<Weapon> optionalToEdit=weaponRepository.findById(id);
        if(optionalToEdit.isPresent()){
            Weapon entityToEdit=optionalToEdit.get();

            entityToEdit.setName(weaponRequestDTO.getName());
            entityToEdit.setPrice(weaponRequestDTO.getPrice());
            entityToEdit.set_personalized(weaponRequestDTO.is_personalized());
            entityToEdit.setDescription(weaponRequestDTO.getDescription());

            weaponRepository.save(entityToEdit);

            return new WeaponResponseDTO(entityToEdit.getId(),entityToEdit.getName(), entityToEdit.is_personalized(), entityToEdit.getPrice(), entityToEdit.getDescription());
        }
        else {
            throw  new EntityNotFoundException("Not found a weapon with ID: "+id);
        }

    }





}
