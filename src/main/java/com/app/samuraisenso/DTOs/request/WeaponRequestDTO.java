package com.app.samuraisenso.DTOs.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class WeaponRequestDTO {
    private String name;

    private boolean is_personalized;

    private double price;

    private String description;
}
