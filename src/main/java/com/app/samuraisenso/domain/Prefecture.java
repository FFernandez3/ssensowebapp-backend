package com.app.samuraisenso.domain;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Prefecture implements Serializable {
    @Id
    private Long id;
    private String name;
    private String image;

    @ManyToMany(mappedBy = "borderingPrefectures", fetch = FetchType.EAGER)
    private List<Prefecture> borderingPrefectures;

    @OneToOne
    private Character ruler;
}
