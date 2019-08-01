package com.whitecloak.training.rpg.model;

public class HeroSkill {

    private int id;

    private String name;

    private SkillEffect skillEffect;

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

    public SkillEffect getSkillEffect() {
        return skillEffect;
    }

    public void setSkillEffect(SkillEffect skillEffect) {
        this.skillEffect = skillEffect;
    }
}
