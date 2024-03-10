package com.app.samuraisenso.repositories;

import com.app.samuraisenso.domain.Weapon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WeaponRepository extends JpaRepository<Weapon, Long> {

}
