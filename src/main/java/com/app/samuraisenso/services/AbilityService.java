package com.app.samuraisenso.services;

import com.app.samuraisenso.DTOs.AbilityRequestDTO;
import com.app.samuraisenso.DTOs.AbilityResponseDTO;
import com.app.samuraisenso.domain.Ability;
import com.app.samuraisenso.repositories.AbilityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
@Service
@RequiredArgsConstructor
public class AbilityService {
    private final AbilityRepository repository;

    public AbilityResponseDTO createAbilities(AbilityRequestDTO request) {
        Ability entity= new Ability(request);
        Ability savedAbility=this.repository.save(entity);
        return new AbilityResponseDTO(savedAbility);
    }
}
