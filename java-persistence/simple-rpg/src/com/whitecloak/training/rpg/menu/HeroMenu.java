package com.whitecloak.training.rpg.menu;


import com.whitecloak.training.rpg.model.Hero;
import com.whitecloak.training.rpg.model.HeroStats;
import com.whitecloak.training.rpg.service.HeroService;
import com.whitecloak.training.rpg.service.impl.HeroServiceImpl;

import java.util.List;
import java.util.Scanner;

public class HeroMenu {

    private final HeroService heroService = new HeroServiceImpl();

    public void createHero(Scanner scanner) {
        System.out.println("Creating Hero...");
        System.out.print("Name: ");
        String name = scanner.nextLine();

        Hero hero = heroService.create(name);
        System.out.printf("Created Hero - %s! (id=%d)\n\n", hero.getName(), hero.getId());
    }

    public void listHeroes() {
        System.out.println("All Heroes:");

        List<Hero> heroes = heroService.listAll();
        if (heroes.isEmpty()) {
            System.out.println("No heroes saved yet!\n");
            return;
        }

        System.out.printf("%-3s|%-16s|%3s|%4s|%4s|%4s|%4s\n", "ID", "Name", "Lv", "PAtk", "PDef", "MAtk", "MDef");

        for (Hero hero : heroes) {
            int id = hero.getId();
            String name = hero.getName();
            int level = hero.getLevel();

            HeroStats heroStats = hero.getStats();
            int physicalAttack = heroStats.getPhysicalAttack();
            int physicalDefense = heroStats.getPhysicalDefense();

            int magicAttack = heroStats.getMagicAttack();
            int magicDefense = heroStats.getMagicDefense();

            System.out.printf("%-3d|%-16s|%3d|%4d|%4d|%4d|%4d\n", id, name, level, physicalAttack, physicalDefense, magicAttack, magicDefense);
        }
    }
}
