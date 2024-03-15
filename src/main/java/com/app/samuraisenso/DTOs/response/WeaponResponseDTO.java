package com.app.samuraisenso.DTOs.response;

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
}
