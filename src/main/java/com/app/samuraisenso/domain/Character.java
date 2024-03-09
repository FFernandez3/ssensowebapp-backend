package com.app.samuraisenso.domain;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Character implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private LocalDate birthday;

    private LocalDate deathDate;

    private String image;

    @OneToMany
    private List<Weapon> weapon;

    @ManyToMany
    @JoinTable(
            name = "character_ability", // Nombre de la tabla de unión
            joinColumns = @JoinColumn(name = "character_id"), // Clave externa de la entidad Character
            inverseJoinColumns = @JoinColumn(name = "ability_id") // Clave externa de la entidad Ability
    )
    private List<Ability> abilities;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "school_id")
    private School school;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "city_id")
    private City deathPlace;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false, name = "clan_id")
    private Clan clan;

}
