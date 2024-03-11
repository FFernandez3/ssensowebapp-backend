package com.app.samuraisenso.services;

import com.app.samuraisenso.DTOs.ClanDTO;
import com.app.samuraisenso.domain.Clan;
import com.app.samuraisenso.repositories.ClanRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
//@RequiredArgsConstructor
public class ClanService {
    @Autowired
    private ClanRepository clanRepository;

    public Clan save(Clan c) throws Exception {
        try{
            return clanRepository.save(c);
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    public Optional<Clan> update(Long id, ClanDTO clanDTO) throws Exception {
        Optional<Clan> optionalClan = clanRepository.findById(id);

        if (optionalClan.isPresent()) {
            Clan clan = optionalClan.get();

            clan.setName(clanDTO.getName());
            clan.setLogo(clanDTO.getLogo());
            clan.setNotableMembers(clanDTO.getNotableMembers());

            clanRepository.save(clan);

            return Optional.of(clan);
        } else {
            throw new RuntimeException("Usuario no encontrado con ID: " + id);
        }
    }

    public boolean deleteById(Long id) throws Exception {
        try{
            if (clanRepository.existsById(id)){
                clanRepository.deleteById(id);
                return true;
            } else{
                throw new Exception();
            }
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    public List<Clan> findAll() throws Exception {
        try{
            return clanRepository.findAll();
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    public Optional<Clan> findById(Long id) {
        return clanRepository.findById(id);
    }
}
