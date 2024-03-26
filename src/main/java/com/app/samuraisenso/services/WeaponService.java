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
            Weapon newWeapon=new Weapon(requestDTO);
            Weapon savedWeapon = this.weaponRepository.save(newWeapon);

            return new WeaponResponseDTO(savedWeapon);
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
    public WeaponResponseDTO deleteById(Long id) throws EntityNotFoundException {
        Weapon entityToDelete = weaponRepository.findById(id).orElseThrow(()->new EntityNotFoundException("No weapon was found with ID: "+id));
        weaponRepository.deleteById(id);

            return new WeaponResponseDTO(entityToDelete);
    }

    @Transactional
    public WeaponResponseDTO edit(Long id, WeaponRequestDTO weaponRequestDTO) throws  EntityNotFoundException{
        Weapon weaponToEdit=weaponRepository.findById(id).orElseThrow(()->new EntityNotFoundException("No weapon was found with ID: "+id));

        weaponToEdit.setName(weaponRequestDTO.getName());
        weaponToEdit.setPrice(weaponRequestDTO.getPrice());
        weaponToEdit.set_personalized(weaponRequestDTO.is_personalized());
        weaponToEdit.setDescription(weaponRequestDTO.getDescription());

        weaponRepository.save(weaponToEdit);

        return new WeaponResponseDTO(weaponToEdit);

    }





}
