package com.whitecloak.training.rpg.service.impl;

import com.whitecloak.training.rpg.gateway.HeroGateway;
import com.whitecloak.training.rpg.gateway.impl.HeroGatewayImpl;
import com.whitecloak.training.rpg.model.Equipments;
import com.whitecloak.training.rpg.model.Hero;
import com.whitecloak.training.rpg.model.HeroStats;
import com.whitecloak.training.rpg.service.HeroService;

import java.util.List;

import static java.util.Collections.emptySet;

public class HeroServiceImpl implements HeroService {

    private final HeroGateway heroGateway = new HeroGatewayImpl();

    @Override
    public Hero create(String name) {
        Hero hero = new Hero();
        hero.setName(name);
        hero.setLevel(1);

        HeroStats initialStats = initializeStats();
        hero.setStats(initialStats);

        Equipments equipments = initializeEquipments();
        hero.setEquipments(equipments);

        hero.setSkills(emptySet());

        return heroGateway.save(hero);
    }

    @Override
    public List<Hero> listAll() {
        return heroGateway.listAll();
    }

    private HeroStats initializeStats() {
        HeroStats stats = new HeroStats();
        stats.setHealth(100);
        stats.setMana(50);
        stats.setStamina(50);

        stats.setPhysicalAttack(10);
        stats.setPhysicalDefense(0);

        stats.setMagicAttack(5);
        stats.setMagicDefense(0);
        return stats;
    }

    private Equipments initializeEquipments() {
        return new Equipments();
    }
}
