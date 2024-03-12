package com.app.samuraisenso.domain;

import com.app.samuraisenso.DTOs.ClanDTO;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Clan implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    private String logo;

    @OneToMany(mappedBy = "clan")
    private List<Character> notableMembers;

    public Clan(ClanDTO clandto){
        this.setLogo(clandto.getLogo());
        this.setName(clandto.getName());
        this.setNotableMembers(clandto.getNotableMembers());
    }
}
