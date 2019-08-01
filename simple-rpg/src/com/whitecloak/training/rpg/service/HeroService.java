package com.whitecloak.training.rpg.service;

import com.whitecloak.training.rpg.model.Hero;

import java.util.List;

public interface HeroService {

    Hero create(String name);

    List<Hero> listAll();
}
