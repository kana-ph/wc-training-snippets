package com.whitecloak.training.rpg.gateway;

import com.whitecloak.training.rpg.model.Hero;

import java.util.List;

public interface HeroGateway {

    Hero save(Hero hero);

    List<Hero> listAll();
}
