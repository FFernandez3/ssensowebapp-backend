package com.app.samuraisenso.DTOs;

import com.app.samuraisenso.domain.Ability;
import com.app.samuraisenso.domain.AbilityType;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AbilityResponseDTO {
    private Long id;
    private String name;
    private String description;
    private AbilityType type;

    public AbilityResponseDTO(Ability entity){
        this.name=entity.getName();
        this.description=entity.getDescription();
        this.id=entity.getId();
        this.type=entity.getType();
    }
}
