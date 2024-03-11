package com.app.samuraisenso.repositories;

import com.app.samuraisenso.domain.Clan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("ClanRepository")
public interface ClanRepository extends JpaRepository<Clan, Long> {

}
