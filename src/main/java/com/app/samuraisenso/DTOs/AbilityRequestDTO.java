package com.app.samuraisenso.DTOs;


import com.app.samuraisenso.domain.AbilityType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AbilityRequestDTO {
    private String name;
    private String description;
    private AbilityType type;



}
