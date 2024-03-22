package com.app.samuraisenso.DTOs.response;

import com.app.samuraisenso.domain.Weapon;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class WeaponResponseDTO {
    private Long id;

    private String name;

    private boolean is_personalized;

    private double price;

    private String description;

    public WeaponResponseDTO(Weapon entity){
        this.id= entity.getId();
        this.name= entity.getName();
        this.description= entity.getDescription();
        this.is_personalized= entity.is_personalized();
        this.price=entity.getPrice();
    }
}
