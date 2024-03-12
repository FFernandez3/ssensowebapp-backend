package com.app.samuraisenso.DTOs;

import com.app.samuraisenso.domain.AbilityType;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AbilityRequestDTO {

    private String name;

    private String description;

    private AbilityType type;
}
