package com.app.samuraisenso.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
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
    private Long id;
    private String name;
    private LocalDate birthday;
    private LocalDate deathDate;
    private String image;

    @OneToMany()
    @JoinColumn
    private List<Weapon> weapon;

    @OneToMany
    @JoinColumn
    private List<Ability> abilities; /*un personaje tiene muchas habilidades?puede no tener?*/

    /*Escuela*/
    /*Clan*/
    /*Lugar de muerte: ciudad*/
}
