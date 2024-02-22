package com.app.samuraisenso.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

import java.io.Serializable;
@Entity
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class City implements Serializable {
    @Id
    private Long id;
    private String name;
    @ManyToOne
    @JoinColumn
    private Prefecture prefecture;
}
