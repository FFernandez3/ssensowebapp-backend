package com.app.samuraisenso.domain;

import com.app.samuraisenso.DTOs.WeaponRequestDTO;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Weapon implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private boolean is_personalized;
    @Column(nullable = false)
    private double price;
    @Column(nullable = false)
    private String description;

    public Weapon(WeaponRequestDTO requestDTO){
        this.name=requestDTO.getName();
        this.is_personalized=requestDTO.is_personalized();
        this.price=requestDTO.getPrice();
        this.description=requestDTO.getDescription();
    }
}
