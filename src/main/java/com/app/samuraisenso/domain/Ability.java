package com.app.samuraisenso.domain;

import com.app.samuraisenso.DTOs.AbilityRequestDTO;
import jakarta.persistence.*;
import lombok.*;
import java.io.Serializable;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ability implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false )
    private AbilityType type;

<<<<<<< HEAD
    public Ability(AbilityRequestDTO requestDTO){
        this.name=requestDTO.getName();
        this.description=requestDTO.getDescription();
        this.type=requestDTO.getType();
=======
    public Ability(AbilityRequestDTO abDto){
        this.setName(abDto.getName());
        this.setType(abDto.getType());
        this.setDescription(abDto.getDescription());
>>>>>>> 809dd023f51afb212fb8ac7e780fae0ee9b8fc5c
    }

}
