package com.app.samuraisenso.domain;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class School implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="school_id")
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String technique;

    @Column(nullable = false)
    private String specialAttack;

    @OneToOne(fetch = FetchType.LAZY)
    private Character master;
}
