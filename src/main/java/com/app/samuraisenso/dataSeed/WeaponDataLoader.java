package com.app.samuraisenso.dataSeed;

import com.app.samuraisenso.domain.Weapon;
import com.app.samuraisenso.repositories.WeaponRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class WeaponDataLoader implements CommandLineRunner {
    private final WeaponRepository repository;

    @Override
    public void run(String... args) throws Exception {
        loadWeaponData();
    }

    private void loadWeaponData() {
        if (repository.count() == 0) {
            Weapon weapon1 = new Weapon(1L, "hacha", true, 300, "Posee un mango de madera de cedro y la hoja es del acero más inoxidable conocido");
            Weapon weapon2 = new Weapon(2L, "Arco y flecha", false, 500, "Tanto el arco como las flechas fueron talladas a mano");

            repository.save(weapon1);
            repository.save(weapon2);
        }


    }
}
