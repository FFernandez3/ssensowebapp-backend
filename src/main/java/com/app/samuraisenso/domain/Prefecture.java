package com.app.samuraisenso.domain;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Prefecture implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String image;

    @ManyToMany
    @JoinTable(
            name = "prefecture_border",
            joinColumns = @JoinColumn(name = "prefecture_id"),
            inverseJoinColumns = @JoinColumn(name = "bordering_prefecture_id")
    )
    private List<Prefecture> borderingPrefectures;

    @ManyToMany(mappedBy = "borderingPrefectures")
    private List<Prefecture> prefecturesBordering;

    @OneToOne(fetch = FetchType.LAZY)
    private Character ruler;
}
