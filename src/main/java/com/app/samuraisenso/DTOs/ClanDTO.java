package com.app.samuraisenso.DTOs;

import com.app.samuraisenso.domain.Character;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class ClanDTO {
    private String name;
    private String logo;
    private List<Character> notableMembers;
}
