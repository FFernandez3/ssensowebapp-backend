package com.app.samuraisenso.domain;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;


@Entity
@Data
@Table(name = "character_table")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Character implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Date birthday;
    private Date deathDate;
    private String image;

    @OneToMany
    //@JoinColumn
    private List<Weapon> weapons;

    @OneToMany
    //@JoinColumn
    private List<Ability> abilities; /*un personaje tiene muchas habilidades?puede no tener?*/

    /*Escuela*/
    /*Clan*/
    /*Lugar de muerte: ciudad*/
}
