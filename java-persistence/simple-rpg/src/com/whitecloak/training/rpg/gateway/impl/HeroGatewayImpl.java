package com.whitecloak.training.rpg.gateway.impl;

import com.whitecloak.training.rpg.gateway.HeroGateway;
import com.whitecloak.training.rpg.model.Hero;

import java.util.*;

public class HeroGatewayImpl implements HeroGateway {

    private final static Map<Integer, Hero> STORAGE = new HashMap<>();

    @Override
    public Hero save(Hero hero) {
        int nextId = computeLastId() + 1;
        hero.setId(nextId);

        STORAGE.put(nextId, hero);
        return hero;
    }

    @Override
    public List<Hero> listAll() {
        List<Hero> heroes = new ArrayList<>(STORAGE.values());
        heroes.sort(Comparator.comparingInt(Hero::getId));

        return heroes;
    }

    private int computeLastId() {
        return STORAGE.keySet()
            .stream()
            .mapToInt(x -> x)
            .max()
            .orElse(0);
    }
}
