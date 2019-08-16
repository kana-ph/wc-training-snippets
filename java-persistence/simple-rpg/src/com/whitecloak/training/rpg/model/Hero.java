package com.whitecloak.training.rpg.model;

import java.util.Set;

public class Hero {

    private int id;

    private String name;

    private int level;

    private HeroStats stats;
    private Equipments equipments;

    private Set<HeroSkill> skills;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public HeroStats getStats() {
        return stats;
    }

    public void setStats(HeroStats status) {
        this.stats = status;
    }

    public Equipments getEquipments() {
        return equipments;
    }

    public void setEquipments(Equipments equipments) {
        this.equipments = equipments;
    }

    public Set<HeroSkill> getSkills() {
        return skills;
    }

    public void setSkills(Set<HeroSkill> skills) {
        this.skills = skills;
    }
}
