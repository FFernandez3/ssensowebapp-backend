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
@Getter
@Setter
public class Character implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private LocalDate birthday;
    private LocalDate deathDate;
    private String image;

    @OneToMany()
    @JoinColumn
    private List<Weapon> weapon;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinColumn
    private List<Ability> abilities;

    @ManyToOne
    private School school;

    @ManyToOne
    private City deathPlace;

    @ManyToOne
    private Clan clan;

}
